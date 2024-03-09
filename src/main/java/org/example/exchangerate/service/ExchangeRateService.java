package org.example.exchangerate.service;

import java.util.Optional;
import org.example.exchangerate.model.ExchangeRate;
import org.example.exchangerate.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateService {

  @Autowired
  ExchangeRateRepository exchangeRateRepository;

  public Flux<ExchangeRate> findAll() {
    return exchangeRateRepository.findAll();
  }

  public Mono<ExchangeRate> findById(Long id) {
    return exchangeRateRepository.findById(id);
  }

  public Mono<ExchangeRate> save(ExchangeRate exchangeRate) {
    exchangeRate.calculateConverted();
    return exchangeRateRepository.save(exchangeRate);
  }

  public Mono<ExchangeRate> update(Long id, ExchangeRate exchangeRate) {
    return exchangeRateRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
      .flatMap(existingExchangeRate -> {
        if (existingExchangeRate.isPresent()) {
          exchangeRate.setId(id);
          exchangeRate.calculateConverted();
          return exchangeRateRepository.save(exchangeRate);
        }
        return Mono.empty();
      });
  }

}
