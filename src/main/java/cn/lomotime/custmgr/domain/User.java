package cn.lomotime.custmgr.domain;

public class User {
  private Integer id;
  private String userName;
  private String realName;
  private String password;
  private Integer managerId;
  private String managerName;
  private String role;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getRealName() {
    return realName;
  }
  
  public void setRealName(String realName) {
    this.realName = realName;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Integer getManagerId() {
    return managerId;
  }
  
  public void setManagerId(Integer managerId) {
    this.managerId = managerId;
  }
  
  public String getManagerName() {
    return managerName;
  }
  
  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
