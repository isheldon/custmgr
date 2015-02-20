package cn.lomotime.custmgr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lomotime.custmgr.domain.User;
import cn.lomotime.custmgr.persistence.UserDao;

@Service
public class UserService {

  @Resource
  private UserDao userDao;
  
  public User login(String userName, String password) {
    return userDao.getUserByLogin(userName, password);
  }
}
