package cn.lomotime.custmgr.persistence;

import java.util.List;

import cn.lomotime.custmgr.domain.User;

public interface UserDao {

  public User getUserById(Integer id);

  public void deleteUserById(Integer id);
  
  public User getUserByLogin(String userName, String password);
  
  public List<User> getUsersByRole(String role);

  public void insertUser(User user);
  
  public void updateRoleToSales(Integer userId);
  
  public void clearManagerId(Integer managerId);
}
