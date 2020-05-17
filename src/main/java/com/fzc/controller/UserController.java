package com.fzc.controller;

import com.fzc.entity.User;
import com.fzc.service.UserService;
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
 * (User)表控制层
 *
 * @author fzc
 * @since 2020-05-10 17:22:37
 */
@Controller
@RequestMapping("user")
@Api(value = "用户Controller", tags = { "用户访问接口" })
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 点击[管理员列表]，查出所有管理员列表，并跳转到admin-list页面显示，
     *
     * @param model
     * @param pn
     * @param size
     * @return
     */
    @GetMapping("selectList")
    @ApiOperation(value = "查询管理员列表")
    public String selectList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(pn, size);
        List<User> users = userService.queryList();
        PageInfo<User> page = new PageInfo<>(users);
        model.addAttribute("users", users);
        model.addAttribute("page", page);
        return "user/admin-list";
    }

    /**
     * 根据id删除用户，然后再次发送查询的请求
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById")
    @ApiOperation(value = "根据id删除用户")
    public String deleteById(@ApiParam("用户id")Integer id) {
        userService.deleteById(id);
        return "redirect:/user/selectList";
    }


    /**
     * 点击[添加]，跳转到admin-add页面
     *
     * @return return前不可以加/
     */
    @GetMapping("to-admin-add")
    @ApiOperation(value = "添加")
    public String toAdminAdd() {
        return "user/admin-add";
    }

    /**
     * 点击编辑，跳转到admin-edit页面
     *
     * @return
     */
    @GetMapping("to-admin-edit/{id}")
    @ApiOperation(value = "编辑")
    public String toAdminEdit(@ApiParam("用户id")@PathVariable("id") Integer id, Model model) {
        User edituser = userService.queryById(id);
        model.addAttribute("edituser", edituser);
        return "user/admin-edit";
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加用户")
    public String add(@ApiParam("用户") User user) {
        userService.insert(user);
        return "redirect:/user/selectList";
    }

    @PostMapping("update")
    @ApiOperation(value = "更新用户信息")
    public String update(@ApiParam("用户") User user) {
        userService.update(user);
        return "redirect:/user/selectList";
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "根据id查询用户")
    public User selectOne(@ApiParam("用户id")Integer id) {
        return this.userService.queryById(id);
    }


    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @GetMapping("usernameSearch/{username}")
    @ApiOperation(value = "根据用户名查询用户")
    public String usernameSearch(@ApiParam("用户名")@PathVariable("username") String username, Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "5") int size){
        //去掉空格
        String name = StringUtils.deleteWhitespace(username);
        PageHelper.startPage(pn, size);
        //根据name查到的username只有一个
        List<User> userList = userService.searchNameList(name);
        PageInfo<User> page = new PageInfo<>(userList);
        model.addAttribute("page",page);
        return "user/admin-list";
    }

    /**
     * 用于添加用户时，异步检测用户名是否已存在
     * @param username
     * @return
     */
    @ResponseBody
    @GetMapping("checkexist/{username}")
    @ApiOperation(value = "检测用户是否存在")
    public String checkexist(@ApiParam("用户名")@PathVariable("username") String username){
        User user = userService.queryByName(username);
        if(user != null){
            return "exist";
        }else {
            return "noexist";
        }
    }
}