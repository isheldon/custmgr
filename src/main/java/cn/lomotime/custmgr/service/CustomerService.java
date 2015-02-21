package cn.lomotime.custmgr.service;

import java.util.List;

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
  private CustomerMemoDao memoDao;
  
  public List<Customer> getCustomersByExample(Customer example) {
    if (example == null) { example = new Customer(); }
    example.prepareForSearch();
    List<Customer> customers = customerDao.getCustomersByExample(example);
    for (Customer customer: customers) {
      CustomerMemo memo = memoDao.getLastMemo(customer.getId());
      if (memo != null) {
        customer.setLastMemo(memo.getMemo());
        customer.setLastMemoTime(memo.getMemoTime());
      }
    }
    return customers;
  }
  
  @Transactional
  public void createCustomer(Customer customer) {
    customerDao.insertCustomer(customer);
  }

}
