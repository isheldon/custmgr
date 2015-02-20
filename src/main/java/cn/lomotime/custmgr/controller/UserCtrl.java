package cn.lomotime.custmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lomotime.custmgr.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCtrl {
  
  @Resource
  private UserService userService;
  
  @RequestMapping("/managers")
  public String getManagers(Model model) {
    model.addAttribute("managers", userService.getManagers());
    return "user/managers";
  }

  @RequestMapping("/manager/new")
  public String newManager() {
    return "user/manager-new";
  }

  @RequestMapping("/manager/create")
  public String createManager(String userName, String realName) {
    userService.createManager(userName, realName);
    return "redirect:/user/managers";
  }

  @RequestMapping("/manager/delete/{id}")
  public String deleteManager(@PathVariable(value="id") Integer id) {
    userService.deleteManager(id);
    return "redirect:/user/managers";
  }
}
