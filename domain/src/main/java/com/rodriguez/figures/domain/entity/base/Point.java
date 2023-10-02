package com.rodriguez.figures.domain.entity.base;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Point {
  private Long x;
  private Long y;

  public Boolean isPointInQ1(Point point) {
    return this.x <= point.getX() && this.y <= point.getY();
  }

  public Boolean isPointInQ2(Point point) {
    return this.x >= point.getX() && this.y <= point.getY();
  }

  public Boolean isPointInQ3(Point point) {
    return this.x >= point.getX() && this.y >= point.getY();
  }

  public Boolean isPointInQ4(Point point) {
    return this.x <= point.getX() && this.y >= point.getY();
  }
}
