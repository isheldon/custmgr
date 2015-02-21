package cn.lomotime.custmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lomotime.custmgr.domain.Customer;
import cn.lomotime.custmgr.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerCtrl {

  @Resource
  private CustomerService customerService;
  
  @RequestMapping("/customers")
  public String getCustomers(Model model, @ModelAttribute("customer") Customer exapmle) {
    model.addAttribute("customers", customerService.getCustomersByExample(exapmle));
    return "customer/customers";
  }
}
