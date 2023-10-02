package com.rodriguez.figures.domain.usecase.service;

import com.rodriguez.figures.domain.usecase.FigureUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.RectangleComparatorCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FiguresUseCaseDescription {
  private FigureUseCase<Boolean, RectangleComparatorCommand> figureUseCase;
  private String validDescription;
}
