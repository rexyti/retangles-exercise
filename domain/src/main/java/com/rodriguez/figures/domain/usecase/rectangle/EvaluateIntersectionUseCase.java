package com.rodriguez.figures.domain.usecase.rectangle;

import com.rodriguez.figures.domain.entity.rectangle.Rectangle;
import com.rodriguez.figures.domain.usecase.FigureUseCase;

public class EvaluateIntersectionUseCase implements FigureUseCase<Boolean, RectangleComparatorCommand> {


  @Override
  public Boolean handle(RectangleComparatorCommand command) {
    return evaluate(command.getRectangleA(), command.getRectangleB())
        || evaluate(command.getRectangleB(), command.getRectangleA());
  }

  private static boolean evaluate(Rectangle rectangleA, Rectangle rectangleB) {
    return (hasPointInside(rectangleA, rectangleB) || hasTwoPointsDifferentLines(rectangleA, rectangleB))
        && hasPointOutSide(rectangleA, rectangleB);
  }

  private static boolean hasPointOutSide(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .anyMatch(point -> !rectangleB.isPointInside(point));
  }

  private static boolean hasPointInside(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .filter(point -> !rectangleB.isPointOnEdge(point))
        .anyMatch(point -> rectangleB.isPointInside(point));
  }

  private static boolean hasTwoPointsDifferentLines(Rectangle rectangleA, Rectangle rectangleB) {
    return rectangleA.getVertices().parallelStream()
        .filter(point -> !rectangleB.isAVertex(point))
        .filter(point -> rectangleB.isPointOnEdge(point))
        .map(point -> rectangleB.getLines().stream()
            .filter(line -> line.isPointInLine(point))
            .findAny().orElseThrow())
        .distinct()
        .count() == 2;
  }
}
