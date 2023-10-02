package com.rodriguez.figures.domain.usecase.rectangle;

import com.rodriguez.figures.domain.usecase.FigureUseCase;

public class EvaluateAdjacencyProperUseCase implements FigureUseCase<Boolean, RectangleComparatorCommand> {
  @Override
  public Boolean handle(RectangleComparatorCommand command) {
    return hasPointOutSide(command) && hasTwoCommonVerticesCount(command);
  }

  private static boolean hasTwoCommonVerticesCount(RectangleComparatorCommand command) {
    return command.getRectangleA().getVertices().parallelStream()
        .filter(point -> command.getRectangleB().isAVertex(point))
        .count() == 2;
  }

  private static boolean hasPointOutSide(RectangleComparatorCommand command) {
    return command.getRectangleB().getVertices().parallelStream()
        .anyMatch(point -> !command.getRectangleA().isPointInside(point));
  }
}
