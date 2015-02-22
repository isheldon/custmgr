package cn.lomotime.custmgr.service;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lomotime.custmgr.domain.Customer;
import cn.lomotime.custmgr.domain.CustomerMemo;
import cn.lomotime.custmgr.persistence.CustomerDao;
import cn.lomotime.custmgr.persistence.CustomerMemoDao;

@Service
public class CustomerService {

  @Resource
  private CustomerDao customerDao;

  @Resource
  private CustomerMemoDao customerMemoDao;

  @Resource
  private CustomerMemoDao memoDao;
  
  public Customer getCustomersById(Integer id) {
    return customerDao.getCustomersById(id);
  }
  
  public List<Customer> getCustomersByExample(Customer example) {
    if (example == null) { example = new Customer(); }
    example.prepareForSearch();
    List<Customer> customers = customerDao.getCustomersByExample(example);
    this.appendMemos(customers);
    return customers;
  }

  public List<Customer> getCustomersByExampleWithManager(Customer example) {
    if (example.getManagerId() == null) {
      throw new RuntimeException("Manager ID not found.");
    }
    example.prepareForSearch();
    List<Customer> customers = customerDao.getCustomersByExampleWithManager(example);
    this.appendMemos(customers);
    return customers;
  }
  
  private void appendMemos(List<Customer> customers) {
    for (Customer customer: customers) {
      CustomerMemo memo = memoDao.getLastMemo(customer.getId());
      if (memo != null) {
        customer.setLastMemo(memo.getMemo());
        customer.setLastMemoTime(memo.getMemoTime());
      }
    }
  }

  public List<Customer> getCustomersByAllocation(String allocation) {
    if ("YES".equals(allocation)) {
      return customerDao.getCustomersWithUserId();
    } else if ("NO".equals(allocation)) {
      return customerDao.getCustomersWithoutUserId();
    } else {
      return this.getCustomersByExample(new Customer());
    }
  }
  
  @Transactional
  public void createCustomer(Customer customer) {
    customerDao.insertCustomer(customer);
  }

  @Transactional
  public void allocateCusomersSales(Integer userId, String[] customerIds) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("userId", userId);
    params.put("customerIds", customerIds);
    customerDao.updateCustomersSales(params);
  }
  
  @Transactional
  public void createCustomerMemo(Integer customerId, String memo, Integer contacted) {
    CustomerMemo cm = new CustomerMemo();
    cm.setCustomerId(customerId);
    cm.setMemo(memo);
    customerMemoDao.insertCustomerMemo(cm);
    customerDao.updateCustomersContacted(customerId, contacted);
  }
  
  public List<CustomerMemo> getCustomerMemos(Integer customerId) {
    return customerMemoDao.getMemos(customerId);
  }
  
}
