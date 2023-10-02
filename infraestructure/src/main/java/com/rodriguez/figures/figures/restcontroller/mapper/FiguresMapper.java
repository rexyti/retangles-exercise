package com.rodriguez.figures.figures.restcontroller.mapper;

import com.rodriguez.figures.domain.usecase.rectangle.RectangleComparatorCommand;
import com.rodriguez.figures.figures.restcontroller.dto.FiguresRequestDto;
import com.rodriguez.figures.figures.restcontroller.dto.FiguresResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FiguresMapper {
  RectangleComparatorCommand toRectangleComparatorCommand(FiguresRequestDto figuresRequestDto);

  FiguresResponseDto toFiguresResponseDto(String result);
}
