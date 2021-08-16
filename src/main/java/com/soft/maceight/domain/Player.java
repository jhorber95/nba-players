package com.soft.maceight.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Player implements Serializable {
    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;

    @JsonProperty(value = "h_meters")
    private Double hMeters;

    @JsonProperty(value = "h_in")
    private Integer hIn;
}
