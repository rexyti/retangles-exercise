package com.rodriguez.figures.figures.restcontroller;

import com.rodriguez.figures.domain.usecase.service.FiguresService;
import com.rodriguez.figures.figures.restcontroller.dto.FiguresRequestDto;
import com.rodriguez.figures.figures.restcontroller.dto.FiguresResponseDto;
import com.rodriguez.figures.figures.restcontroller.mapper.FiguresMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/figures/rectangles/evaluate", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FiguresController {

  private final FiguresService figuresService;

  private final FiguresMapper figuresMapper;

  @PostMapping()
  public Flux<FiguresResponseDto> itemDetailCreated(@RequestBody FiguresRequestDto request) {
    return figuresService.evaluateRectangles(figuresMapper.toRectangleComparatorCommand(request))
        .map(figuresMapper::toFiguresResponseDto);
  }
}
