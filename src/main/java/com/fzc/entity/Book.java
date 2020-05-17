package com.fzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (Book)实体类
 *
 * @author fzc
 * @since 2020-05-09 14:36:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = -37395183798253996L;
    
    private Integer id;
    
    private String bookname;
    
    private String pub;
    
    private Double price;

    private Date date;
    
    private Integer count;
    
    private String kind;




}