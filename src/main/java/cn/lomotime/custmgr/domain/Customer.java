package cn.lomotime.custmgr.domain;

public class Customer {

  private Integer id;
  private String orgName;
  private String orgAddress;
  private String contactName;
  private String contactPhone;
  private String email;
  private String qq;
  private Integer contacted;
  private Integer userId;
  private String userName;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getOrgName() {
    return orgName;
  }
  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }
  public String getOrgAddress() {
    return orgAddress;
  }
  public void setOrgAddress(String orgAddress) {
    this.orgAddress = orgAddress;
  }
  public String getContactName() {
    return contactName;
  }
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }
  public String getContactPhone() {
    return contactPhone;
  }
  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getQq() {
    return qq;
  }
  public void setQq(String qq) {
    this.qq = qq;
  }
  public Integer getContacted() {
    return contacted;
  }
  public void setContacted(Integer contacted) {
    this.contacted = contacted;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
}
