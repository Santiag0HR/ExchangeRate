package org.example.exchangerate.model;

import org.springframework.data.annotation.Id;

public class ExchangeRate {

  @Id
  private Long id;
  private String source;
  private String target;
  private Double rate;
  private Double amount;
  private Double converted;

  public void calculateConverted() {
    if (rate != null && amount != null) {
      converted = rate * amount;
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getConverted() {
    return converted;
  }

  public void setConverted(Double converted) {
    this.converted = converted;
  }
}
