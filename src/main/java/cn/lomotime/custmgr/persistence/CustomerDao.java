package cn.lomotime.custmgr.persistence;

import java.util.List;

import cn.lomotime.custmgr.domain.Customer;

public interface CustomerDao {

  List<Customer> getCustomersByExample(Customer example);

  public void insertCustomer(Customer customer);
}
