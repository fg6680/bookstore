package com.fzc.controller;

/*
 * @author fzc
 * @since 2020-05-10 11:22:37
*/

import com.fzc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "登录Controller", tags = { "登录访问接口" })
public class LoginController {

    @GetMapping({"login", "/"})
    @ApiOperation(value = "登录")
    public String login() {
        return "login";
    }

    @PostMapping("tologin")
    @ApiOperation(value = "登录验证")
    public String tologin(@ApiParam("用户") User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //login认证通过后，便可拿到shiro保存的用户对象
            User user1 = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user", user1);
            return "redirect:/index";

        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (ExcessiveAttemptsException e) {
            model.addAttribute("msg", "登录失败次数过多");
            return "login";
        } catch (LockedAccountException e) {
            model.addAttribute("msg", "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");
            return "login";
        } catch (DisabledAccountException e) {
            model.addAttribute("msg", "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");
            return "login";
        } catch (ExpiredCredentialsException e) {
            model.addAttribute("msg", "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");
            return "login";
        } catch (UnauthorizedException e) {
            model.addAttribute("msg", "您没有得到相应的授权！" + e.getMessage());
            return "login";
        }
    }

    @GetMapping("index")
    @ApiOperation(value = "去首页")
    public String toindex() {
        return "index";
    }

    @GetMapping("/noauth")
    @ApiOperation(value = "去无权限页")
    public String noauth() {
        return "noauth";
    }

    @GetMapping("welcome")
    @ApiOperation(value = "去欢迎页")
    public String welcome(){
        return "wel";
    }

}
