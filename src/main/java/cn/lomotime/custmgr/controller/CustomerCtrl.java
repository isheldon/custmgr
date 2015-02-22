package cn.lomotime.custmgr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lomotime.custmgr.domain.Customer;
import cn.lomotime.custmgr.domain.User;
import cn.lomotime.custmgr.service.CustomerService;
import cn.lomotime.custmgr.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerCtrl {

  @Resource
  private CustomerService customerService;

  @Resource
  private UserService userSerivce;
  
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
    List<User> users = userSerivce.getManagers();
    users.addAll(userSerivce.getSalespersons());
    model.addAttribute("users", users);
    return "customer/customer-allocate";
  }

  @RequestMapping("/allocate")
  public String allocateSales(HttpServletRequest request) {
    Integer userId = Integer.parseInt(request.getParameter("userId"));
    String[] customerIds = request.getParameterValues("customerId");
    customerService.allocateCusomersSales(userId, customerIds);
    return "redirect:/customer/toAllocate";
  }
}
