package com.inkombizz.web.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class ProductAddRequest {

    private Integer idProduct;

    @NotNull
    private String productName;

    @NotNull
    private String productPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productExpire;
}