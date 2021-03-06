package cn.lomotime.custmgr.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.lomotime.custmgr.domain.User;
import cn.lomotime.custmgr.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class LoginCtrl {

  @Resource
  private UserService userService;

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
  public String doLogin(Model model, String userName, String password) {
    User user = userService.login(userName, password);
    if (user == null) {
      model.addAttribute("loginMsg", 1);
      return "login";
    }
    model.addAttribute("loginUser", user);
    return "redirect:/index";
  }

  @RequestMapping("/logout")
  public String logout(Model model, SessionStatus status) {
    status.setComplete();
    model.addAttribute("loginMsg", 2);
    return "login";
  }

  @RequestMapping("/password")
  public String password() {
    return "password";
  }

  @RequestMapping(value = "/chgpwd", method = RequestMethod.POST)
  public String changePassword(HttpSession session, Model model, String password) {
    User user = (User) session.getAttribute("loginUser");
    userService.changeUserPassword(user.getId(), password);
    model.addAttribute("pwdMsg", 1);
    return "password";
  }

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "index";
  }

}
