package com.fzc.dao;

import com.fzc.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author fzc
 * @since 2020-05-09 15:12:23
 */
@Mapper
public interface ArticleDao {

    //查询所有的文章
    List<Article> queryArticles();

    //新增一个文章
    int addArticle(Article article);

    //根据文章id查询文章
    Article getArticleById(int id);

    //根据文章id删除文章
    int deleteArticleById(int id);
}