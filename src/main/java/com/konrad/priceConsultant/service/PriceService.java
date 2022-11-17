package com.konrad.priceConsultant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.konrad.priceConsultant.dto.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class PriceService {

    Logger logger = LoggerFactory.getLogger(PriceService.class);

    @Value("${coingecko.base.url}")
    private String baseURL;

    @Value("${coingecko.search}")
    private String search;

    @Autowired
    RestTemplate restTemplate;
    Gson gson = new Gson();

    public List<Coin> searchCoin(String coin) throws JsonProcessingException {
        String path = "?query=";
        String uri = baseURL + search + path + coin;
        logger.info("Request to URI: {}", uri);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity response = restTemplate.getForEntity(uri, Coin.class);
        List<Coin> coinList = new ArrayList<>();
        Type coinsTypeList = new TypeToken<Coin[]>(){}.getType();
        //List<Coin> coinList = gson.fromJson(String.valueOf(response.getBody()), Coin.class);
        //Coin[] responseCoin = response.getBody();
        //List<Coin> m = Arrays.asList(responseCoin);
        //List<Coin> readValues = new ObjectMapper().readValue(
//                response.getBody(), new TypeReference<List<Coin>>() { }
//        );
        //Coin[] coins = response.getBody();
        return coinList;
//        ResponseEntity<List<Coin>> response = restTemplate.getForEntity(url, Coin.class);
//        return response;
    }
}
