package com.rodriguez.figures.domain.usecase;

public interface FigureUseCase<E, C> {
  E handle(C command);
}
