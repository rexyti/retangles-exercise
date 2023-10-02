package com.rodriguez.figures.domain.usecase.rectangle;

import com.rodriguez.figures.domain.entity.rectangle.Rectangle;
import com.rodriguez.figures.domain.usecase.FigureUseCase;

public class EvaluateAdjacencySubLineUseCase implements FigureUseCase<Boolean, RectangleComparatorCommand> {
  @Override
  public Boolean handle(RectangleComparatorCommand command) {
    return evaluate(command.getRectangleA(), command.getRectangleB())
        || evaluate(command.getRectangleB(), command.getRectangleA());
  }

  private static boolean evaluate(Rectangle rectangleA, Rectangle rectangleB) {
    return hasPointOutSide(rectangleA, rectangleB)
        && hasTwoPointsInTheEdge(rectangleA, rectangleB)
        && hasLessThanTwoCommonVertices(rectangleA, rectangleB)
        && hasTwoPointsInOneLines(rectangleA, rectangleB);
  }

  private static boolean hasLessThanTwoCommonVertices(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .filter(point -> rectangleB.isAVertex(point))
        .count() < 2;
  }

  private static boolean hasTwoPointsInTheEdge(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .filter(point -> rectangleB.isPointOnEdge(point))
        .count() == 2;
  }

  private static boolean hasPointOutSide(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .anyMatch(point -> !rectangleB.isPointInside(point));
  }

  private static boolean hasTwoPointsInOneLines(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .filter(point -> !rectangleB.isAVertex(point))
        .filter(point -> rectangleB.isPointOnEdge(point))
        .map(point -> rectangleB.getLines().stream()
            .filter(line -> line.isPointInLine(point))
            .findAny().orElseThrow())
        .distinct()
        .count() == 1;
  }


}
