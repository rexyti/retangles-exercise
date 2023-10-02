package com.rodriguez.figures.domain.usecase.rectangle;

import static com.rodriguez.figures.domain.usecase.RectangleTestCase.rectangleBase;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rodriguez.figures.domain.usecase.RectangleTestCase;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class EvaluateAdjacencySubLineUseCaseTest {

  EvaluateAdjacencySubLineUseCase evaluateAdjacencySubLineUseCase = new EvaluateAdjacencySubLineUseCase();

  private List<RectangleTestCase> expectTrueUseCases = Arrays.asList(
      RectangleTestCase.subLineHorizontalAdjacent,
      RectangleTestCase.subLineVerticalAdjacent
  );

  private List<RectangleTestCase> expectFalseUseCases = Arrays.asList(
      RectangleTestCase.inside,
      RectangleTestCase.insideV1,
      RectangleTestCase.insideV2,
      RectangleTestCase.insideV3,
      RectangleTestCase.insideV4,
      RectangleTestCase.insideHorizontalEdge,
      RectangleTestCase.insideVerticalEdge,
      RectangleTestCase.properVerticalAdjacent,
      RectangleTestCase.properHorizontalAdjacent,
      RectangleTestCase.partialHorizontalAdjacent,
      RectangleTestCase.partialVerticalAdjacent,
      RectangleTestCase.partialOneCommonVertexAdjacent,
      RectangleTestCase.oneVertexInsideIntersection,
      RectangleTestCase.twoVertexInsideIntersection,
      RectangleTestCase.twoVertexOnEdgeIntersection,
      RectangleTestCase.oneVertexOnEdgeIntersection,
      RectangleTestCase.outsideRectangle
  );

  @Test
  void handle_true() {
    expectTrueUseCases.stream().forEach(rectangleTestCase -> {
      assertTrue(evaluateAdjacencySubLineUseCase.handle(
          new RectangleComparatorCommand(rectangleBase, rectangleTestCase.getTestRectangle())), rectangleTestCase.getName());
      assertTrue(evaluateAdjacencySubLineUseCase.handle(
          new RectangleComparatorCommand(rectangleTestCase.getTestRectangle(), rectangleBase)), rectangleTestCase.getName());
    });
  }

  @Test
  void handle_false() {
    expectFalseUseCases.stream().forEach(rectangleTestCase -> {
      assertFalse(evaluateAdjacencySubLineUseCase.handle(
          new RectangleComparatorCommand(rectangleBase, rectangleTestCase.getTestRectangle())), rectangleTestCase.getName());
      assertFalse(evaluateAdjacencySubLineUseCase.handle(
          new RectangleComparatorCommand(rectangleTestCase.getTestRectangle(), rectangleBase)), rectangleTestCase.getName());
    });
  }
}