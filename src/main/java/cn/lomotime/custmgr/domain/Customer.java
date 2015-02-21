package cn.lomotime.custmgr.domain;

import java.sql.Timestamp;

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
  
  private String lastMemo;
  private Timestamp lastMemoTime;
  
  public void prepareForSearch() {
    if (orgName != null && orgName.length() == 0) { orgName = null; }
    if (contactName != null && contactName.length() == 0) { contactName = null; }
    if (contactPhone != null && contactPhone.length() == 0) { contactPhone = null; }
    if (userName != null && userName.length() == 0) { userName = null; }
  }

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
  public String getLastMemo() {
    return lastMemo;
  }
  public void setLastMemo(String lastMemo) {
    this.lastMemo = lastMemo;
  }
  public Timestamp getLastMemoTime() {
    return lastMemoTime;
  }
  public void setLastMemoTime(Timestamp lastMemoTime) {
    this.lastMemoTime = lastMemoTime;
  }
  
}
