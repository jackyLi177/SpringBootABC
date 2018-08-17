package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author : liyongjie
 * @Date : 2018/6/7
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Forecast{

    private String date;
    private String high;
    private String low;
    private String fengli;
    private String fengxiang;
    private String type;
    private String fl;
    private String fx;

}
