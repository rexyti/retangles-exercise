package com.rodriguez.figures.domain.rectangle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rodriguez.figures.domain.entity.base.Point;
import com.rodriguez.figures.domain.entity.rectangle.RectangleLine;
import org.junit.jupiter.api.Test;

class RectangleLineTest {

  @Test
  void isPointInLine_pointIsInVerticalAxis_true() {
    var line1 = new RectangleLine(new Point(0L, 10L), new Point(0L, 0L));
    var line2 = new RectangleLine(new Point(0L, 0L), new Point(0L, 10L));
    var pointInLine = new Point(0L, 2L);
    var pointInVortex1 = new Point(0L, 0L);
    var pointInVortex2 = new Point(0L, 10L);
    assertTrue(line1.isPointInLine(pointInLine));
    assertTrue(line1.isPointInLine(pointInVortex1));
    assertTrue(line1.isPointInLine(pointInVortex2));
    assertTrue(line2.isPointInLine(pointInLine));
    assertTrue(line2.isPointInLine(pointInVortex1));
    assertTrue(line2.isPointInLine(pointInVortex2));
  }

  @Test
  void isPointInLine_pointIsInHorizontalAxis_true() {
    var line1 = new RectangleLine(new Point(10L, 0L), new Point(0L, 0L));
    var line2 = new RectangleLine(new Point(0L, 0L), new Point(10L, 0L));
    var pointInLine = new Point(2L, 0L);
    var pointInVortex1 = new Point(0L, 0L);
    var pointInVortex2 = new Point(10L, 0L);
    assertTrue(line1.isPointInLine(pointInLine));
    assertTrue(line1.isPointInLine(pointInVortex1));
    assertTrue(line1.isPointInLine(pointInVortex2));
    assertTrue(line2.isPointInLine(pointInLine));
    assertTrue(line2.isPointInLine(pointInVortex1));
    assertTrue(line2.isPointInLine(pointInVortex2));
  }

  @Test
  void isPointInLine_pointIsInHorizontalAxis_false() {
    var line1 = new RectangleLine(new Point(0L, 10L), new Point(0L, 0L));
    var line2 = new RectangleLine(new Point(0L, 0L), new Point(0L, 10L));
    var pointOutside1 = new Point(0L, 11L);
    var pointOutside2 = new Point(0L, -1L);
    assertFalse(line1.isPointInLine(pointOutside1));
    assertFalse(line1.isPointInLine(pointOutside2));
    assertFalse(line2.isPointInLine(pointOutside1));
    assertFalse(line2.isPointInLine(pointOutside2));
  }

  @Test
  void isPointInLine_pointIsInVerticalAxis_false() {
    var line1 = new RectangleLine(new Point(10L, 0L), new Point(0L, 0L));
    var line2 = new RectangleLine(new Point(0L, 0L), new Point(10L, 0L));
    var pointOutside1 = new Point(11L, 0L);
    var pointOutside2 = new Point(-1L, -0L);
    assertFalse(line1.isPointInLine(pointOutside1));
    assertFalse(line1.isPointInLine(pointOutside2));
    assertFalse(line2.isPointInLine(pointOutside1));
    assertFalse(line2.isPointInLine(pointOutside2));
  }

  @Test
  void isPointInLine_pointNotInLine_false() {
    var line1 = new RectangleLine(new Point(10L, 0L), new Point(0L, 0L));
    var line2 = new RectangleLine(new Point(0L, 0L), new Point(10L, 0L));
    var pointOutside = new Point(1L, 1L);
    assertFalse(line1.isPointInLine(pointOutside));
    assertFalse(line2.isPointInLine(pointOutside));
  }

}