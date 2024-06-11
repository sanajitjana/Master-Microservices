package com.sanajitjana.microservices.currency_conversion_service.controller;

import com.sanajitjana.microservices.currency_conversion_service.model.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
    }

}
