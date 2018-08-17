package com.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : liyongjie
 * @Date : 2018/6/7 0007
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherDetails {

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private List<Forecast> forecast;
}
