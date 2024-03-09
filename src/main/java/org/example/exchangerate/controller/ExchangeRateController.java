package org.example.exchangerate.controller;

import org.example.exchangerate.model.ExchangeRate;
import org.example.exchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ExchangeRateController {

  @Autowired
  ExchangeRateService exchangeRateService;

  @GetMapping("/exchange-rate")
  @ResponseStatus(HttpStatus.OK)
  public Flux<ExchangeRate> listExchangeRate() {
    return exchangeRateService.findAll();
  }

  @GetMapping("/exchange-rate/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ExchangeRate> findExchangeRate(@PathVariable("id") Long id) {
    return exchangeRateService.findById(id);
  }

  @PostMapping("/exchange-rate")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<ExchangeRate> save(@RequestBody ExchangeRate exchangeRate) {
    return exchangeRateService.save(exchangeRate);
  }

  @PutMapping("/exchange-rate/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ExchangeRate> update(@PathVariable("id") Long id, @RequestBody ExchangeRate exchangeRate) {
    return exchangeRateService.update(id, exchangeRate);
  }

}
