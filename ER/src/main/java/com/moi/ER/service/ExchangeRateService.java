package com.moi.ER.service;


import com.moi.ER.model.ExchangeRate;
import com.moi.ER.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ExchangeRateService {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;


    public List<ExchangeRate> getAllExchangeRates(){
        return exchangeRateRepository.findAll();
    }

    //SORTING
    public List<ExchangeRate> findExchangeRateWithSorting(String field){
        return exchangeRateRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    //PAGINATION
    public Page<ExchangeRate> findExchangeRatesWithPagination(int offset, int pageSize){
        Page<ExchangeRate> exchangeRates = exchangeRateRepository.findAll(PageRequest.of(offset, pageSize));
        return exchangeRates;
    }

    public List<ExchangeRate> findExchangeRateByDate(Date date) {
        return exchangeRateRepository.findByDate(date);
    }



    @Cacheable(value="exchangeRates", key="#id")
    public Optional<ExchangeRate> getExchangeRateById(Long id){
        return exchangeRateRepository.findById(id);
    }

    public ExchangeRate createExchangeRate(ExchangeRate exchangeRate){
        return exchangeRateRepository.save(exchangeRate);
    }
    public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate){
        return exchangeRateRepository.save(exchangeRate);
    }
    public void deleteExchangeRate(Long id){
        exchangeRateRepository.deleteById(id);
    }
}
