package org.example.exchangerate.repository;

import org.example.exchangerate.model.ExchangeRate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ExchangeRateRepository extends R2dbcRepository<ExchangeRate, Long> {

}
