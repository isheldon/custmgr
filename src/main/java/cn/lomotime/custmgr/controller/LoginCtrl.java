package cn.lomotime.custmgr.controller;

import javax.annotation.Resource;

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

  @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
  public String doLogin(Model model, String userName, String password) {
    User user = userService.login(userName, password);
    if (user == null) {
      model.addAttribute("loginMsg", 1);
      return "login";
    }
    model.addAttribute("loginUser", user);
    return "redirect:/user/managers";
  }

  @RequestMapping("/logout")
  public String logout(Model model, SessionStatus status) {
    status.setComplete();
    model.addAttribute("loginMsg", 2);
    return "login";
  }

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }
}
