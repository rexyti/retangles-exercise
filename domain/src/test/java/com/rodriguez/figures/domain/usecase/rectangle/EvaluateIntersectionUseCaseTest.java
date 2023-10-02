package com.rodriguez.figures.domain.usecase.rectangle;

import static com.rodriguez.figures.domain.usecase.RectangleTestCase.rectangleBase;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rodriguez.figures.domain.usecase.RectangleTestCase;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class EvaluateIntersectionUseCaseTest {

  EvaluateIntersectionUseCase evaluateIntersectionUseCase = new EvaluateIntersectionUseCase();

  private List<RectangleTestCase> expectTrueUseCases = Arrays.asList(
      RectangleTestCase.oneVertexInsideIntersection,
      RectangleTestCase.twoVertexInsideIntersection,
      RectangleTestCase.twoVertexOnEdgeIntersection,
      RectangleTestCase.oneVertexOnEdgeIntersection
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
      RectangleTestCase.subLineHorizontalAdjacent,
      RectangleTestCase.subLineVerticalAdjacent,
      RectangleTestCase.outsideRectangle
  );

  @Test
  void handle_true() {
    expectTrueUseCases.stream().forEach(rectangleTestCase -> {
      assertTrue(evaluateIntersectionUseCase.handle(
          new RectangleComparatorCommand(rectangleBase, rectangleTestCase.getTestRectangle())), rectangleTestCase.getName());
      assertTrue(evaluateIntersectionUseCase.handle(
          new RectangleComparatorCommand(rectangleTestCase.getTestRectangle(), rectangleBase)), rectangleTestCase.getName());
    });
  }

  @Test
  void handle_false() {
    expectFalseUseCases.stream().forEach(rectangleTestCase -> {
      assertFalse(evaluateIntersectionUseCase.handle(
          new RectangleComparatorCommand(rectangleBase, rectangleTestCase.getTestRectangle())), rectangleTestCase.getName());
      assertFalse(evaluateIntersectionUseCase.handle(
          new RectangleComparatorCommand(rectangleTestCase.getTestRectangle(), rectangleBase)), rectangleTestCase.getName());
    });
  }
}