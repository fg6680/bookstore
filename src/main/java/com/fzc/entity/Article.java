package com.fzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author fzc
 * @since 2020-05-09 09:12:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = -86149542952698496L;
    /**
    * int文章的唯一ID
    */
    private Integer id;
    /**
    * 作者
    */
    private String author;
    /**
    * 标题
    */
    private String title;
    /**
    * 文章的内容
    */
    private String content;


}