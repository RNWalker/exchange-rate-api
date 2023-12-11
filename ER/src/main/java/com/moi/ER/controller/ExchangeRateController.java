package com.moi.ER.controller;

import com.moi.ER.model.ExchangeRate;
import com.moi.ER.service.ExchangeRateService;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    ExchangeRateService exchangeRateService;

//INDEX
    @GetMapping("/all")
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRates(){
        try {
            List<ExchangeRate> allExchangeRates = exchangeRateService.getAllExchangeRates();
            return new ResponseEntity<>(allExchangeRates, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //GET

    @GetMapping("{id}")
    public ResponseEntity<ExchangeRate> getExchangeRateById (@PathVariable Long id){
        try {
            Optional<ExchangeRate> exchangeRate = exchangeRateService.getExchangeRateById(id);
            if (exchangeRate.isPresent()) {
                // Add Cache-Control header with max-age=3600 seconds (1 hour)
                CacheControl cacheControl = CacheControl.maxAge(3600, TimeUnit.SECONDS);
                return new ResponseEntity<>(exchangeRate.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //POST
    @PostMapping
    public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRate){
        try {
            ExchangeRate newExchangeRate = exchangeRateService.createExchangeRate(exchangeRate);
            return new ResponseEntity<>(newExchangeRate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //PUT

    @PutMapping
    public ResponseEntity<ExchangeRate> updateExchangeRate(@RequestBody ExchangeRate exchangeRate){
        try {
            ExchangeRate updatedExchangeRate = exchangeRateService.updateExchangeRate(exchangeRate);
            return new ResponseEntity<>(updatedExchangeRate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<ExchangeRate> deleteExchangeRate(@PathVariable Long id) {
        exchangeRateService.deleteExchangeRate(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }








}
