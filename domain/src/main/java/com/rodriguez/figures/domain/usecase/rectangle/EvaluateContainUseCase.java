package com.rodriguez.figures.domain.usecase.rectangle;

import com.rodriguez.figures.domain.usecase.FigureUseCase;

public class EvaluateContainUseCase implements FigureUseCase<Boolean, RectangleComparatorCommand> {
  @Override
  public Boolean handle(RectangleComparatorCommand command) {
    return command.getRectangleB().getVertices().parallelStream()
        .filter(point -> command.getRectangleA().isPointInside(point))
        .count() == 4;
  }
}
