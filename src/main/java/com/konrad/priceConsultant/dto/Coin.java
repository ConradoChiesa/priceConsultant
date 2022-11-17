package com.konrad.priceConsultant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coin {

    private String id;
    private String name;
    private String api_symbol;
    private String symbol;
    private int market_cap_rank;
    private String thumb;
    private String large;
    
}
