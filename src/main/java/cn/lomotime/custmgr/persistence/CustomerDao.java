package cn.lomotime.custmgr.persistence;

import java.util.List;
import java.util.Map;

import cn.lomotime.custmgr.domain.Customer;

public interface CustomerDao {

  Customer getCustomersById(Integer id);

  List<Customer> getCustomersByExample(Customer example);

  List<Customer> getCustomersByExampleWithManager(Customer example);
 
  public void insertCustomer(Customer customer);

  public void updateCustomer(Customer customer);
  
  List<Customer> getCustomersWithUserId();
  List<Customer> getCustomersWithoutUserId();
  
  public void updateCustomersSales(Map<String, Object> params);
  
  public void updateCustomersContacted(Integer customerId, Integer contacted);
}
