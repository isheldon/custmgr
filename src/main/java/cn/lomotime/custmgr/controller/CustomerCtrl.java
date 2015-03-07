package cn.lomotime.custmgr.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.lomotime.custmgr.domain.Customer;
import cn.lomotime.custmgr.domain.User;
import cn.lomotime.custmgr.service.CustomerService;
import cn.lomotime.custmgr.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerCtrl {
  private static Logger logger = Logger.getLogger(CustomerCtrl.class);

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
  public String newCustomer(HttpSession session, Model model) {
    Customer customer = new Customer();
    User currentUser = this.getCurrentUser(session);
    if (!"ADMIN".equals(currentUser.getRole())) {
      customer.setUserId(currentUser.getId());
    }
    model.addAttribute("customer", customer);
    return "customer/customer-new";
  }

  @RequestMapping("/importCustomers")
  public String importCustomers(MultipartFile customerFile) throws IOException {
    //String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");
    BufferedReader br = new BufferedReader(
        new InputStreamReader(customerFile.getInputStream(), "UTF-8"));
    try {
      String line = null;
      while ((line = br.readLine())!= null) {
        logger.debug("import line:\n" + line);
        String[] props = line.split(",");
        Customer customer = new Customer();
        customer.setOrgName(props[0]);
        customer.setOrgAddress(props[1]);
        customer.setContactName(props[2]);
        customer.setContactPhone(props[3]);
        customer.setEmail(props[4]);
        customer.setQq(props[5]);
        customerService.createCustomer(customer);
      }
    } finally {
      br.close();
    }
    return "redirect:/customer/customers";
  }

  @RequestMapping("/create")
  public String createCustomer(@ModelAttribute("customer") Customer customer) {
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
  
  @RequestMapping("/newMemo/{customerId}")
  public String newMemo(@PathVariable(value="customerId") Integer customerId, Model model) {
    model.addAttribute("customer", customerService.getCustomersById(customerId));
    model.addAttribute("memos", customerService.getCustomerMemos(customerId));
    return "customer/memo-new";
  }
  
  @RequestMapping("/memohistory/{customerId}")
  public String histroyMemos(HttpSession session,
      @PathVariable(value="customerId") Integer customerId, Model model) {
    model.addAttribute("memos", customerService.getCustomerMemos(customerId));
    if ("ADMIN".equals(getCurrentUser(session).getRole())) {
      model.addAttribute("backPath", "customers");
    } else {
      model.addAttribute("backPath", "subcustomers");
    }
    return "customer/memo-history";
  }
  
  @RequestMapping("/createMemo")
  public String createMemo(Integer customerId, String memo, Integer contacted) {
    customerService.createCustomerMemo(customerId, memo, contacted);
    return "redirect:/customer/selfcustomers";
  }

  @RequestMapping("/edit/{id}")
  public String editCustomer(HttpSession session,
      Model model, @PathVariable(value="id") Integer id) {
    model.addAttribute("customer", customerService.getCustomersById(id));
    if ("ADMIN".equals(getCurrentUser(session).getRole())) {
      model.addAttribute("backPath", "../customers");
    } else {
      model.addAttribute("backPath", "../selfcustomers");
    }
    return "customer/customer-edit";
  }
  
  @RequestMapping("/update")
  public String updateCustomer(HttpSession session, @ModelAttribute("customer") Customer customer) {
    customerService.updateCustomer(customer);
    if ("ADMIN".equals(getCurrentUser(session).getRole())) {
      return "redirect:/customer/customers";
    }
    return "redirect:/customer/selfcustomers";
  }

  private User getCurrentUser(HttpSession session) {
    return (User) session.getAttribute("loginUser");
  }
}
