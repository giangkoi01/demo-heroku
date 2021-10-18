package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO implements Serializable {

    private Integer id;

    private String name;

    private String image;

    private Float price;

    private Date createDate;

    private Integer categoryId;

}
