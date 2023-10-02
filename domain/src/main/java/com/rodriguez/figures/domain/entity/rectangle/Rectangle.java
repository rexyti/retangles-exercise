package com.rodriguez.figures.domain.entity.rectangle;

import com.rodriguez.figures.domain.entity.base.Point;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class Rectangle {
  private Point mainVertex;
  private Long height;
  private Long weight;
  private List<Point> vertices;
  private List<RectangleLine> lines;

  public Rectangle(Point mainVertex, Long height, Long weight) {
    this.mainVertex = mainVertex;
    this.height = height;
    this.weight = weight;
    this.vertices = Arrays.asList(mainVertex
        , new Point(this.mainVertex.getX(), this.mainVertex.getY() + this.height)
        , new Point(this.mainVertex.getX() + this.weight, this.mainVertex.getY() + this.height)
        , new Point(this.mainVertex.getX() + this.weight, this.mainVertex.getY()));
    this.lines = Arrays.asList(new RectangleLine(vertices.get(0), vertices.get(1))
        , new RectangleLine(vertices.get(1), vertices.get(2))
        , new RectangleLine(vertices.get(2), vertices.get(3))
        , new RectangleLine(vertices.get(3), vertices.get(0))
    );
  }

  public Boolean isPointInside(Point point) {
    Point vertex3 = new Point(this.mainVertex.getX() + this.weight, this.mainVertex.getY() + this.height);
    return mainVertex.isPointInQ1(point) && vertex3.isPointInQ3(point);
  }

  public Boolean isPointOnEdge(Point point) {
    return getLines().parallelStream()
        .anyMatch(rectangleLine -> rectangleLine.isPointInLine(point));
  }

  public Boolean isAVertex(Point point) {
    return getVertices().parallelStream()
        .anyMatch(pointToCompare -> pointToCompare.equals(point));
  }

}
