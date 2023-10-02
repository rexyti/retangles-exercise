package com.rodriguez.figures.domain.base;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rodriguez.figures.domain.entity.base.Point;
import org.junit.jupiter.api.Test;

class PointTest {

  private Point basePoint = new Point(0L, 0L);
  private Point q1Point = new Point(1L, 1L);
  private Point q2Point = new Point(-1L, 1L);
  private Point q3Point = new Point(-1L, -1L);
  private Point q4Point = new Point(1L, -10L);
  private Point positiveXPoint = new Point(1L, 0L);
  private Point negativeXPoint = new Point(-1L, 0L);
  private Point positiveYPoint = new Point(0L, 1L);
  private Point negativeYPoint = new Point(0L, -1L);

  @Test
  void isPointInQ1() {
    assertTrue(basePoint.isPointInQ1(q1Point));
    assertFalse(basePoint.isPointInQ1(q2Point));
    assertFalse(basePoint.isPointInQ1(q3Point));
    assertFalse(basePoint.isPointInQ1(q4Point));
    assertTrue(basePoint.isPointInQ1(positiveXPoint));
    assertFalse(basePoint.isPointInQ1(negativeXPoint));
    assertTrue(basePoint.isPointInQ1(positiveYPoint));
    assertFalse(basePoint.isPointInQ1(negativeYPoint));
  }

  @Test
  void isPointInQ2() {
    assertFalse(basePoint.isPointInQ2(q1Point));
    assertTrue(basePoint.isPointInQ2(q2Point));
    assertFalse(basePoint.isPointInQ2(q3Point));
    assertFalse(basePoint.isPointInQ2(q4Point));
    assertFalse(basePoint.isPointInQ2(positiveXPoint));
    assertTrue(basePoint.isPointInQ2(negativeXPoint));
    assertTrue(basePoint.isPointInQ2(positiveYPoint));
    assertFalse(basePoint.isPointInQ2(negativeYPoint));
  }

  @Test
  void isPointInQ3() {
    assertFalse(basePoint.isPointInQ3(q1Point));
    assertFalse(basePoint.isPointInQ3(q2Point));
    assertTrue(basePoint.isPointInQ3(q3Point));
    assertFalse(basePoint.isPointInQ3(q4Point));
    assertFalse(basePoint.isPointInQ3(positiveXPoint));
    assertTrue(basePoint.isPointInQ3(negativeXPoint));
    assertFalse(basePoint.isPointInQ3(positiveYPoint));
    assertTrue(basePoint.isPointInQ3(negativeYPoint));
  }

  @Test
  void isPointInQ4() {
    assertFalse(basePoint.isPointInQ4(q1Point));
    assertFalse(basePoint.isPointInQ4(q2Point));
    assertFalse(basePoint.isPointInQ4(q3Point));
    assertTrue(basePoint.isPointInQ4(q4Point));
    assertTrue(basePoint.isPointInQ4(positiveXPoint));
    assertFalse(basePoint.isPointInQ4(negativeXPoint));
    assertFalse(basePoint.isPointInQ4(positiveYPoint));
    assertTrue(basePoint.isPointInQ4(negativeYPoint));
  }

}