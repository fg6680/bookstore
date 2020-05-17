package com.fzc.controller;

import com.fzc.entity.Book;
import com.fzc.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Book)表控制层
 *
 * @author fzc
 * @since 2020-05-11 15:42:37
 */
@Controller
@RequestMapping("book")
@Api(value = "图书Controller", tags = { "图书访问接口" })
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;


    @GetMapping("selectList")
    @ApiOperation(value = "查询图书列表")
    public String selectList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size){
        PageHelper.startPage(pn, size);
        List<Book> books = bookService.queryList();
        PageInfo<Book> page = new PageInfo<>(books);
        model.addAttribute("page",page);
        return "book/book-list";
    }


    /**
     * 点击[添加]，跳转到book-add页面
     *
     * @return return前不可以加/
     */
    @GetMapping("to-book-add")
    @ApiOperation(value = "到指定图书添加页面")
    public String toBookAdd() {
        return "book/book-add";
    }

    /**
     *
     * @param book
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加图书")
    public String add(@ApiParam("图书") Book book) {
        bookService.insert(book);
        return "redirect:/book/selectList";
    }

    /**
     * 根据id删除图书，然后再次发送查询的请求
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById")
    @ApiOperation(value = "通过id删除图书")
    public String deleteById(@ApiParam("图书id")Integer id) {
        bookService.deleteById(id);
        return "redirect:/book/selectList";
    }


    /**
     * 点击编辑，book-edit页面
     *
     * @return
     */
    @GetMapping("to-book-edit/{id}")
    @ApiOperation(value = "到指定图书编辑页面")
    public String toAdminEdit(@ApiParam("图书id")@PathVariable("id") Integer id, Model model) {
        Book editbook = bookService.queryById(id);
        model.addAttribute("editbook", editbook);
        return "book/book-edit";
    }

    @PostMapping("update")
    @ApiOperation(value = "更新图书信息")
    public String update(@ApiParam("图书") Book book) {
        bookService.update(book);
        return "redirect:/book/selectList";
    }

    @GetMapping("toSearchList/{kind}")
    @ApiOperation(value = "查询图书列表")
    public String toSearchList(@PathVariable("kind") String kind, Model model,@RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "5") int size){
        //去掉空格
        String skind = StringUtils.deleteWhitespace(kind);
        PageHelper.startPage(pn, size);
        List<Book> books = bookService.queryByKind(kind);
        PageInfo<Book> page = new PageInfo<>(books);
        model.addAttribute("page",page);
        return "book/book-list";
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "通过id查询单条数据")
    public Book selectOne(@ApiParam("图书id")Integer id) {
        return this.bookService.queryById(id);
    }


}