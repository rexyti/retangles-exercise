package com.rodriguez.figures.domain.entity.rectangle;

import com.rodriguez.figures.domain.entity.base.Line;
import com.rodriguez.figures.domain.entity.base.Point;
import lombok.Getter;

@Getter
public class RectangleLine extends Line {
  public RectangleLine(Point point1, Point point2) {
    super(point1, point2);
  }

  public Boolean isPointInLine(Point point) {
    return isPointInVerticalAxis(point) && areNumbersSequential(this.getPoint1().getY(), point.getY(), getPoint2().getY())
        || isPointInHorizontalAxis(point) && areNumbersSequential(this.getPoint1().getX(), point.getX(), getPoint2().getX());
  }

  private Boolean isPointInVerticalAxis(Point point) {
    return this.getPoint1().getX() == this.getPoint2().getX() && point.getX() == this.getPoint1().getX();
  }

  private Boolean isPointInHorizontalAxis(Point point) {
    return this.getPoint1().getY() == this.getPoint2().getY() && point.getY() == this.getPoint1().getY();
  }

  private Boolean areNumbersSequential(Long l1, Long l2, Long l3) {
    return (l1 >= l2 && l2 >= l3) || (l3 >= l2 && l2 >= l1);
  }
}
