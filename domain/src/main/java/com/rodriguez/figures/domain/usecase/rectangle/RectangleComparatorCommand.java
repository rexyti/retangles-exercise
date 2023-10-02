package com.rodriguez.figures.domain.usecase.rectangle;

import com.rodriguez.figures.domain.entity.rectangle.Rectangle;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RectangleComparatorCommand {
  private Rectangle rectangleA;
  private Rectangle rectangleB;
}
