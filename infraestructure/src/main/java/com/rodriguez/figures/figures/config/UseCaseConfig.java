package com.rodriguez.figures.figures.config;

import com.rodriguez.figures.domain.usecase.rectangle.EvaluateAdjacencyPartialUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateAdjacencyProperUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateAdjacencySubLineUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateContainUseCase;
import com.rodriguez.figures.domain.usecase.rectangle.EvaluateIntersectionUseCase;
import com.rodriguez.figures.domain.usecase.service.FiguresService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

  @Bean
  public EvaluateAdjacencyPartialUseCase evaluateAdjacencyPartialUseCase() {
    return new EvaluateAdjacencyPartialUseCase();
  }

  @Bean
  public EvaluateAdjacencyProperUseCase evaluateAdjacencyProperUseCase() {
    return new EvaluateAdjacencyProperUseCase();
  }

  @Bean
  public EvaluateAdjacencySubLineUseCase evaluateAdjacencySubLineUseCase() {
    return new EvaluateAdjacencySubLineUseCase();
  }

  @Bean
  public EvaluateContainUseCase evaluateContainUseCase() {
    return new EvaluateContainUseCase();
  }

  @Bean
  public EvaluateIntersectionUseCase evaluateIntersectionUseCase() {
    return new EvaluateIntersectionUseCase();
  }

  @Bean
  public FiguresService figuresService(EvaluateAdjacencyPartialUseCase evaluateAdjacencyPartialUseCase,
                                       EvaluateAdjacencyProperUseCase evaluateAdjacencyProperUseCase,
                                       EvaluateAdjacencySubLineUseCase evaluateAdjacencySubLineUseCase,
                                       EvaluateContainUseCase evaluateContainUseCase,
                                       EvaluateIntersectionUseCase evaluateIntersectionUseCase) {
    return new FiguresService(evaluateAdjacencyPartialUseCase
        , evaluateAdjacencyProperUseCase
        , evaluateAdjacencySubLineUseCase
        , evaluateContainUseCase
        , evaluateIntersectionUseCase);
  }
}
