package cn.lomotime.custmgr.domain;

import java.sql.Timestamp;

public class CustomerMemo {

  private Integer id;
  private Timestamp memoTime;
  private String memo;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Timestamp getMemoTime() {
    return memoTime;
  }
  public void setMemoTime(Timestamp memoTime) {
    this.memoTime = memoTime;
  }
  public String getMemo() {
    return memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }

}
