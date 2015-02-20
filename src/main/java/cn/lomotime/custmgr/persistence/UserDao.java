package cn.lomotime.custmgr.persistence;

import cn.lomotime.custmgr.domain.User;

public interface UserDao {

  public User getUserById(Integer id);
  
  public User getUserByLogin(String userName, String password);
}
