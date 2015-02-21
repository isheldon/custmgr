package cn.lomotime.custmgr.persistence;

import cn.lomotime.custmgr.domain.CustomerMemo;

public interface CustomerMemoDao {

  public CustomerMemo getLastMemo(Integer customerId);
}
