package cn.lomotime.custmgr.persistence;

import java.util.List;
import java.util.Map;

import cn.lomotime.custmgr.domain.Customer;

public interface CustomerDao {

  List<Customer> getCustomersByExample(Customer example);

  public void insertCustomer(Customer customer);
  
  List<Customer> getCustomersWithUserId();
  List<Customer> getCustomersWithoutUserId();
  
  public void updateCustomersSales(Map<String, Object> params);
}
