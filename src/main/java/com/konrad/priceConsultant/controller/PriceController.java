package com.konrad.priceConsultant.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.konrad.priceConsultant.dto.Coin;
import com.konrad.priceConsultant.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {

    Logger logger = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService priceService;

    @GetMapping("${coingecko.search}")
    public ResponseEntity<List<Coin>> searchCoin(@RequestParam(name = "query") String coin) throws JsonProcessingException {
        logger.info("Searching cypto currency {}", coin);
        return new ResponseEntity<>(priceService.searchCoin(coin), HttpStatus.OK);

    }
}
