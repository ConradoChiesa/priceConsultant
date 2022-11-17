package com.konrad.priceConsultant.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data", "errors"})
public class RestStandardResponse<T, S> {
    @Override
    public String toString() {
        return "RestStandardResponse{data=" + data + ", errors=" + errors +'}';
    }

    @ApiModelProperty(notes = "Response data")
    @JsonProperty("data")
    private List<T> data;

    @ApiModelProperty(notes = "Errors list")
    @JsonProperty("errors")
    private List<S> errors;
}
