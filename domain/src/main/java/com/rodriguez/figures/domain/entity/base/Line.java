package com.rodriguez.figures.domain.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Line {
  private Point point1;
  private Point point2;

  public abstract Boolean isPointInLine(Point point);
}
