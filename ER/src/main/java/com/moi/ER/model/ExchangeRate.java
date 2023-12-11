package com.moi.ER.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startCurrency;
    private String targetCurrency;
    private double rate;

    private LocalDate date;

    public ExchangeRate(String startCurrency, String targetCurrency, double rate, LocalDate date) {
        this.startCurrency = startCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
        this.date = date;
    }

    public ExchangeRate(){}

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getStartCurrency() {
        return startCurrency;
    }

    public void setStartCurrency(String startCurrency) {
        this.startCurrency = startCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
