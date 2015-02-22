package cn.lomotime.custmgr.persistence;

import java.util.List;

import cn.lomotime.custmgr.domain.CustomerMemo;

public interface CustomerMemoDao {

  public CustomerMemo getLastMemo(Integer customerId);
  
  public List<CustomerMemo> getMemos(Integer customerId);
  
  public void insertCustomerMemo(CustomerMemo memo);
}
