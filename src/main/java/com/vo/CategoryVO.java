package com.vo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
public class CategoryVO implements Serializable {

    private Integer Id;

    private String name;

    private List<ProductVO> products;
}
