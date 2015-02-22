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

  @RequestMapping("/new")
  public String newManager(Model model) {
    model.addAttribute("customer", new Customer());
    return "customer/customer-new";
  }

  @RequestMapping("/create")
  public String createManager(@ModelAttribute("customer") Customer customer) {
    customerService.createCustomer(customer);
    return "redirect:/customer/customers";
  }

  @RequestMapping("/toAllocate")
  public String toAllocate(Model model, String allocation) {
    model.addAttribute("customers", customerService.getCustomersByAllocation(allocation));
    model.addAttribute("allocation", allocation);
    return "customer/customer-allocate";
  }
}
