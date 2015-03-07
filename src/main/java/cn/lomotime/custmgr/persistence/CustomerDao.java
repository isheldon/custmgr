package cn.lomotime.custmgr.persistence;

import java.util.List;
import java.util.Map;

import cn.lomotime.custmgr.domain.Customer;

public interface CustomerDao {

  public Customer getCustomersById(Integer id);

  public void deleteCustomerById(Integer id);

  public List<Customer> getCustomersByExample(Customer example);

  public List<Customer> getCustomersByExampleWithManager(Customer example);
 
  public void insertCustomer(Customer customer);

  public void updateCustomer(Customer customer);
  
  public List<Customer> getCustomersWithUserId();

  public List<Customer> getCustomersWithoutUserId();
  
  public void updateCustomersSales(Map<String, Object> params);
  
  public void updateCustomersContacted(Integer customerId, Integer contacted);
}
