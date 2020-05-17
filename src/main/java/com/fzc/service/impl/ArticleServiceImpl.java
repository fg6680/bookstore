package com.fzc.service.impl;

import com.fzc.dao.ArticleDao;
import com.fzc.entity.Article;
import com.fzc.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author fzc
 * @since 2020-05-09 17:39:51
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;


    @Override
    public List<Article> queryArticles() {
        return articleDao.queryArticles();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleDao.getArticleById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteArticleById(int id) {
        return articleDao.deleteArticleById(id);
    }
}