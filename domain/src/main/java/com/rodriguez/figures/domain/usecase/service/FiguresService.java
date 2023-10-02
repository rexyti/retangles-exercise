package com.rodriguez.figures.domain.usecase.service;

import com.rodriguez.figures.domain.usecase.rectangle.EvaluateAdjacencyPartialUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateAdjacencyProperUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateAdjacencySubLineUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateContainUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateIntersectionUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.RectangleComparatorCommand;
import java.util.Arrays;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class FiguresService {
  private final List<FiguresUseCaseDescription> useCases;
  private final FiguresUseCaseDescription evaluateBContainsAUseCase;

  public FiguresService(EvaluateAdjacencyPartialUseCase evaluateAdjacencyPartialUseCase,
                        EvaluateAdjacencyProperUseCase evaluateAdjacencyProperUseCase,
                        EvaluateAdjacencySubLineUseCase evaluateAdjacencySubLineUseCase,
                        EvaluateContainUseCase evaluateContainUseCase,
                        EvaluateIntersectionUseCase evaluateIntersectionUseCase) {
    this.useCases = Arrays.asList(
        new FiguresUseCaseDescription(evaluateAdjacencyPartialUseCase, "Is partial adjacent relationship"),
        new FiguresUseCaseDescription(evaluateAdjacencyProperUseCase, "Is proper adjacent relationship "),
        new FiguresUseCaseDescription(evaluateAdjacencySubLineUseCase, "Is sub-line adjacent relationship"),
        new FiguresUseCaseDescription(evaluateContainUseCase, "A contains B"),
        new FiguresUseCaseDescription(evaluateIntersectionUseCase, "Is intersection relationship")
    );

    this.evaluateBContainsAUseCase = new FiguresUseCaseDescription(evaluateContainUseCase, "B contains A");
  }

  public Flux<String> evaluateRectangles(RectangleComparatorCommand command) {
    return Flux.fromIterable(useCases)
        .filter(figuresUseCaseDescription -> figuresUseCaseDescription.getFigureUseCase().handle(command))
        .map(FiguresUseCaseDescription::getValidDescription)
        .mergeWith(evaluateBContainsA(command))
        .switchIfEmpty(Mono.just("A is outside B"));
  }

  private Mono<String> evaluateBContainsA(RectangleComparatorCommand baseCommand) {
    final RectangleComparatorCommand command = new RectangleComparatorCommand(baseCommand.getRectangleB(), baseCommand.getRectangleA());
    return Mono.just(evaluateBContainsAUseCase)
        .filter(figuresUseCaseDescription -> evaluateBContainsAUseCase.getFigureUseCase().handle(command))
        .map(FiguresUseCaseDescription::getValidDescription);
  }
}
