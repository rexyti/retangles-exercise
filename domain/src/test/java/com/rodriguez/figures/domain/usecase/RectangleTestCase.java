package com.rodriguez.figures.domain.usecase;

import com.rodriguez.figures.domain.entity.base.Point;
import com.rodriguez.figures.domain.entity.rectangle.Rectangle;


public class RectangleTestCase {

  private String name;
  private Rectangle testRectangle;

  public RectangleTestCase(Rectangle testRectangle, String name) {
    this.name = name;
    this.testRectangle = testRectangle;
  }

  public String getName() {
    return name;
  }

  public Rectangle getTestRectangle() {
    return testRectangle;
  }

  public static final Rectangle rectangleBase = new Rectangle(
      new Point(1L, 1l), 5L, 8L);

  public static final RectangleTestCase oneVertexInsideIntersection = new RectangleTestCase(
      new Rectangle(new Point(2L, 2l), 5L, 8L), "one vertex inside intersection");

  public static final RectangleTestCase twoVertexInsideIntersection = new RectangleTestCase(
      new Rectangle(
          new Point(2L, 2l), 3L, 12L), "two vertex inside intersection");

  public static final RectangleTestCase twoVertexOnEdgeIntersection = new RectangleTestCase(
      new Rectangle(
          new Point(2L, 1l), 5L, 12L), "two vertex on edge intersection");

  public static final RectangleTestCase oneVertexOnEdgeIntersection = new RectangleTestCase(
      new Rectangle(
          new Point(2L, 1l), 7L, 12L), "one vertex on edge intersection");

  public static final RectangleTestCase inside = new RectangleTestCase(
      new Rectangle(
          new Point(2L, 2l), 1L, 1L), "inside");

  public static final RectangleTestCase insideV1 = new RectangleTestCase(
      new Rectangle(
          new Point(1L, 1l), 1L, 1L), "inside v1");

  public static final RectangleTestCase insideV2 = new RectangleTestCase(
      new Rectangle(
          new Point(1L, 5l), 1L, 1L), "inside v2");

  public static final RectangleTestCase insideV3 = new RectangleTestCase(
      new Rectangle(
          new Point(8L, 5l), 1L, 1L), "inside v3");

  public static final RectangleTestCase insideV4 = new RectangleTestCase(
      new Rectangle(
          new Point(8L, 1l), 1L, 1L), "inside v4");

  public static final RectangleTestCase insideHorizontalEdge = new RectangleTestCase(
      new Rectangle(
          new Point(2L, 1l), 1L, 1L), "inside horizontal edge");

  public static final RectangleTestCase insideVerticalEdge = new RectangleTestCase(
      new Rectangle(
          new Point(1L, 2l), 1L, 1L), "inside vertical edge");

  public static final RectangleTestCase properVerticalAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(1L, 6l), 1L, 8L), "proper vertical adjacent");

  public static final RectangleTestCase properHorizontalAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(9L, 1l), 5L, 1L), "proper horizontal adjacent");

  public static final RectangleTestCase partialHorizontalAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(2L, 6l), 1L, 10L), "partial horizontal adjacent");

  public static final RectangleTestCase partialVerticalAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(9L, 2l), 10L, 1L), "partial vertical adjacent");

  public static final RectangleTestCase partialOneCommonVertexAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(9L, 6l), 10L, 1L), "one common vertex adjacent");

  public static final RectangleTestCase subLineHorizontalAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(1L, 6l), 1L, 1L), "sub-line horizontal adjacent");

  public static final RectangleTestCase subLineVerticalAdjacent = new RectangleTestCase(
      new Rectangle(
          new Point(9L, 1l), 1L, 1L), "sub-line vertical adjacent");

  public static final RectangleTestCase outsideRectangle = new RectangleTestCase(
      new Rectangle(
          new Point(10L, 10l), 1L, 1L), "outside");
}
