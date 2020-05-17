package com.fzc.service;

import com.fzc.entity.Article;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author fzc
 * @since 2020-05-09 16:16:27
 */
public interface ArticleService {

    //查询所有的文章
    List<Article> queryArticles();

    //新增一个文章
    int addArticle(Article article);

    //根据文章id查询文章
    Article getArticleById(int id);

    //根据文章id删除文章
    int deleteArticleById(int id);

}