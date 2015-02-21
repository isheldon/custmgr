package cn.lomotime.custmgr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lomotime.custmgr.Const;
import cn.lomotime.custmgr.domain.User;
import cn.lomotime.custmgr.persistence.UserDao;

@Service
public class UserService {

  @Resource
  private UserDao userDao;
  
  public User login(String userName, String password) {
    return userDao.getUserByLogin(userName, password);
  }
  
  public User getUserById(Integer id) {
    return userDao.getUserById(id);
  }
  
  @Transactional
  public void deleteSalesperson(Integer id) {
    userDao.deleteUserById(id);
  }
  
  @Transactional
  public void deleteManager(Integer id) {
    userDao.updateRoleToSales(id);
    userDao.clearManagerId(id);
  }
  
  public List<User> getManagers() {
    return userDao.getUsersByRole(Const.ROLE_MANAGER);
  }
  
  @Transactional
  public void createManager(String userName, String realName) {
    User manager = newUser(userName, realName, Const.ROLE_MANAGER);
    userDao.insertUser(manager);
  }
  
  @Transactional
  public void createSalesperson(String userName, String realName, Integer managerId) {
    User salesperson = newUser(userName, realName, Const.ROLE_SALES);
    salesperson.setManagerId(managerId);
    userDao.insertUser(salesperson);
  }
  
  @Transactional
  public void updateUserSelective(User userTempl) {
    userDao.updateUserSelective(userTempl);
  }

  public List<User> getSalespersons() {
    return userDao.getUsersByRole(Const.ROLE_SALES);
  }
  
  private User newUser(String userName, String realName, String role) {
    User user = new User();
    user.setUserName(userName);
    user.setRealName(realName);
    user.setPassword("123456");
    user.setRole(role);
    return user;
  }
}
