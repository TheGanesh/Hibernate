package com.ganesh.hibernate.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="USER_ID")
  private int userId;
  
  @Column(name="USER_NAME")
  private String userName;
  
  @Column(name = "JOINED_DATE")
  @Temporal(TemporalType.DATE)
  private Date joinedDate;
  
  @Transient
  private String password;
  
  @Lob
  @Column(name="BACKGROUND")
  private String background;
  
  @Embedded
  private Address address;
  
  
  
  
  public Address getAddress() {
    return address;
  }
  public void setAddress(Address address) {
    this.address = address;
  }
  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public Date getJoinedDate() {
    return joinedDate;
  }
  public void setJoinedDate(Date joinedDate) {
    this.joinedDate = joinedDate;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getBackground() {
    return background;
  }
  public void setBackground(String background) {
    this.background = background;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + userId;
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserDetails other = (UserDetails) obj;
    if (userId != other.userId)
      return false;
    return true;
  }
  
  

}
