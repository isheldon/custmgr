package cn.lomotime.custmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lomotime.custmgr.domain.User;
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
  public String newManager() { return "user/manager-new"; }

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

  @RequestMapping("/salespersons")
  public String getSalespersons(Model model) {
    model.addAttribute("salespersons", userService.getSalespersons());
    return "user/salespersons";
  }

  @RequestMapping("/salesperson/new")
  public String newSalesperson(Model model) {
    model.addAttribute("managers", userService.getManagers());
    return "user/salesperson-new";
  }
  
  @RequestMapping("/salesperson/create")
  public String createSalesperson(String userName, String realName, Integer managerId) {
    userService.createSalesperson(userName, realName, managerId);
    return "redirect:/user/salespersons";
  }

  @RequestMapping("/salesperson/edit/{id}")
  public String editSalesperson(Model model, @PathVariable(value="id") Integer id) {
    model.addAttribute("salesperson", userService.getUserById(id));
    model.addAttribute("managers", userService.getManagers());
    return "user/salesperson-edit";
  }

  @RequestMapping("/salesperson/update")
  public String updateSalesperson(@ModelAttribute("salesperson") User salespserson) {
    userService.updateUserSelective(salespserson);
    return "redirect:/user/salespersons";
  }

  @RequestMapping("/salesperson/delete/{id}")
  public String deleteSalesperson(@PathVariable(value="id") Integer id) {
    userService.deleteSalesperson(id);
    //TODO customerService.clearSales(id);
    return "redirect:/user/salespersons";
  }
  
}
