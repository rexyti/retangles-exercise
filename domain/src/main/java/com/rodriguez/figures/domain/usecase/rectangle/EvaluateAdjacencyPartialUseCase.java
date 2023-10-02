package com.rodriguez.figures.domain.usecase.rectangle;

import com.rodriguez.figures.domain.usecase.FigureUseCase;

public class EvaluateAdjacencyPartialUseCase implements FigureUseCase<Boolean, RectangleComparatorCommand> {
  @Override
  public Boolean handle(RectangleComparatorCommand command) {
    return hasOnePointOnEdge(command) && hasTreePointsOutside(command)
        && !hasBPointsInsideA(command) && !hasBTwoPointsOnAEdge(command);
  }

  private static boolean hasOnePointOnEdge(RectangleComparatorCommand command) {
    return command.getRectangleA().getVertices().parallelStream()
        .filter(point -> command.getRectangleB().isPointOnEdge(point))
        .count() == 1;
  }

  private static boolean hasTreePointsOutside(RectangleComparatorCommand command) {
    return command.getRectangleA().getVertices().parallelStream()
        .filter(point -> !command.getRectangleB().isPointInside(point))
        .count() == 3;
  }

  private static boolean hasBPointsInsideA(RectangleComparatorCommand command) {
    return command.getRectangleB().getVertices().parallelStream()
        .filter(point -> !command.getRectangleA().isPointOnEdge(point))
        .anyMatch(point -> command.getRectangleA().isPointInside(point));
  }

  private static boolean hasBTwoPointsOnAEdge(RectangleComparatorCommand command) {
    return command.getRectangleB().getVertices().parallelStream()
        .filter(point -> command.getRectangleA().isPointOnEdge(point))
        .count() == 2;
  }
}
