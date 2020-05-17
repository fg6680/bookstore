package com.fzc.controller;

import com.alibaba.fastjson.JSONObject;
import com.fzc.entity.Article;
import com.fzc.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * (Article)表控制层
 *
 * @author fzc
 * @since 2020-05-12 10:55:28
 */
@Controller
@RequestMapping("article")
@Api(value = "文章Controller", tags = { "文章访问接口" })
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * 跳转到编辑页面
     *
     * @return
     */
    @GetMapping("/toEditor")
    @ApiOperation(value = "跳转到编辑页面")
    public String toEditor() {
        return "editor/editormd";
    }


    /**
     * 处理图片上传
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    //博客图片上传问题
    @RequestMapping("/file/upload")
    @ResponseBody
    @ApiOperation(value = "处理图片上传")
    public JSONObject fileUpload(@ApiParam("图片")@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request) throws IOException {
        //上传路径保存设置

        //获得SpringBoot当前项目的路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "/upload/";

        //按照月份进行分类：
        Calendar instance = Calendar.getInstance();
        String month = (instance.get(Calendar.MONTH) + 1) + "月";
        path = path + month;

        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }

        //上传文件地址
        System.out.println("上传文件保存地址：" + realPath);

        //解决文件名字问题：我们使用uuid;
        String filename = "pg-" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
        File newfile = new File(realPath, filename);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newfile);

        //给editormd进行回调
        JSONObject res = new JSONObject();
        res.put("url", "/upload/" + month + "/" + filename);
        res.put("success", 1);
        res.put("message", "upload success!");

        return res;
    }


    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @PostMapping("/addArticle")
    @ApiOperation(value = "添加文章")
    public String addArticle(@ApiParam("文章")Article article) {
        articleService.addArticle(article);
        return "editor/editormd";
    }

    /**
     * 查看文章列表
     *
     * @param model
     * @param pn
     * @param size
     * @return
     */
    @GetMapping("articleList")
    @ApiOperation(value = "查看文章列表")
    public String articleList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(pn, size);
        List<Article> articles = articleService.queryArticles();
        PageInfo<Article> page = new PageInfo<>(articles);
        model.addAttribute("page", page);
        return "editor/articles";
    }


    /**
     * 跳转到具体文章查看页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "跳转到具体文章查看页面")
    public String show(@ApiParam("文章id")@PathVariable("id") int id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "editor/article";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteArticle")
    @ApiOperation(value = "根据id删除文章")
    public String deleteArticle(@ApiParam("文章id")Integer id) {
        articleService.deleteArticleById(id);
        return "editor/articles";
    }

}