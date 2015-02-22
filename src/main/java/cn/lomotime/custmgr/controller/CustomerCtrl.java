package cn.lomotime.custmgr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
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
  //private static Logger logger = Logger.getLogger(CustomerCtrl.class);

  @Resource
  private CustomerService customerService;

  @Resource
  private UserService userSerivce;
  
  @RequestMapping("/customers")
  public String getCustomers(Model model, @ModelAttribute("customer") Customer example) {
    model.addAttribute("customers", customerService.getCustomersByExample(example));
    model.addAttribute("formAction", "customers");
    return "customer/customers";
  }

  @RequestMapping("/selfcustomers")
  public String getSelfCustomers(HttpSession session, Model model, @ModelAttribute("customer") Customer example) {
    if (example == null) { example = new Customer(); }
    User currentUser = this.getCurrentUser(session);
    example.setUserId(currentUser.getId());
    model.addAttribute("customers", customerService.getCustomersByExample(example));
    model.addAttribute("formAction", "selfcustomers");
    return "customer/customers";
  }

  @RequestMapping("/subcustomers")
  public String getSubCustomers(HttpSession session, Model model, @ModelAttribute("customer") Customer example) {
    if (example == null) { example = new Customer(); }
    User currentUser = this.getCurrentUser(session);
    example.setManagerId(currentUser.getId());
    model.addAttribute("customers", customerService.getCustomersByExampleWithManager(example));
    model.addAttribute("formAction", "subcustomers");
    return "customer/customers";
  }

  @RequestMapping("/new")
  public String newManager(HttpSession session, Model model) {
    Customer customer = new Customer();
    User currentUser = this.getCurrentUser(session);
    if (!"ADMIN".equals(currentUser.getRole())) {
      customer.setUserId(currentUser.getId());
    }
    model.addAttribute("customer", customer);
    return "customer/customer-new";
  }

  @RequestMapping("/create")
  public String createManager(@ModelAttribute("customer") Customer customer) {
    customerService.createCustomer(customer);
    String returnPath = "redirect:/customer/customers";
    if (customer.getUserId() != null) { returnPath = "redirect:/customer/selfcustomers"; }
    return returnPath;
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
  
  private User getCurrentUser(HttpSession session) {
    return (User) session.getAttribute("loginUser");
  }
}
