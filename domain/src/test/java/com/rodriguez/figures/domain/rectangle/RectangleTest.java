package com.rodriguez.figures.domain.rectangle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rodriguez.figures.domain.entity.base.Point;
import com.rodriguez.figures.domain.entity.rectangle.Rectangle;
import org.junit.jupiter.api.Test;

class RectangleTest {

  private final Rectangle rectangle = new Rectangle(
      new Point(1L, 1L),
      5L,
      8L);

  @Test
  void isPointInside_pointIsInside_true() {
    var insidePoint = new Point(2L, 2L);
    var bottomPoint = new Point(2L, 6L);
    var topPoint = new Point(2L, 1L);
    var leftPoint = new Point(1L, 2L);
    var rightPoint = new Point(9L, 2L);

    rectangle.getVertices().stream().forEach(
        point -> assertTrue(rectangle.isPointInside(point))
    );

    assertTrue(rectangle.isPointInside(insidePoint));
    assertTrue(rectangle.isPointInside(bottomPoint));
    assertTrue(rectangle.isPointInside(topPoint));
    assertTrue(rectangle.isPointInside(leftPoint));
    assertTrue(rectangle.isPointInside(rightPoint));
  }

  @Test
  void isPointInside_pointIsOutside_false() {
    var outsidePoint1 = new Point(0L, 0L);
    var outsidePoint2 = new Point(1L, 10L);
    var outsidePoint3 = new Point(1L, 0L);
    var outsidePoint4 = new Point(0L, 9L);
    var outsidePoint5 = new Point(7L, 9L);

    assertFalse(rectangle.isPointInside(outsidePoint1));
    assertFalse(rectangle.isPointInside(outsidePoint2));
    assertFalse(rectangle.isPointInside(outsidePoint3));
    assertFalse(rectangle.isPointInside(outsidePoint4));
    assertFalse(rectangle.isPointInside(outsidePoint5));
  }

  @Test
  void isPointOnEdge_pointOnEdge_true() {
    var bottomPoint = new Point(2L, 6L);
    var topPoint = new Point(2L, 1L);
    var leftPoint = new Point(1L, 2L);
    var rightPoint = new Point(9L, 2L);

    rectangle.getVertices().stream().forEach(
        point -> assertTrue(rectangle.isPointOnEdge(point))
    );

    assertTrue(rectangle.isPointOnEdge(bottomPoint));
    assertTrue(rectangle.isPointOnEdge(topPoint));
    assertTrue(rectangle.isPointOnEdge(leftPoint));
    assertTrue(rectangle.isPointOnEdge(rightPoint));
  }

  @Test
  void isPointOnEdge_pointIsInside_false() {
    var insidePoint = new Point(2L, 2L);

    assertFalse(rectangle.isPointOnEdge(insidePoint));
  }

  @Test
  void isPointOnEdge_pointIsOutside_false() {
    var outsidePoint1 = new Point(0L, 0L);
    var outsidePoint2 = new Point(1L, 10L);
    var outsidePoint3 = new Point(1L, 0L);
    var outsidePoint4 = new Point(0L, 9L);
    var outsidePoint5 = new Point(7L, 9L);

    assertFalse(rectangle.isPointOnEdge(outsidePoint1));
    assertFalse(rectangle.isPointOnEdge(outsidePoint2));
    assertFalse(rectangle.isPointOnEdge(outsidePoint3));
    assertFalse(rectangle.isPointOnEdge(outsidePoint4));
    assertFalse(rectangle.isPointOnEdge(outsidePoint5));
  }
}