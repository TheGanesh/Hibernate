package com.ganesh.hibernate.namedquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="UserDetails.byId",query="select userName from UserDetails where userId > :userId")
@NamedNativeQuery(name="USER_DETAILS.byId",query="select * from USER_DETAILS where USER_ID > :userId",resultClass=UserDetails.class)
@Table(name="USER_DETAILS")
public class UserDetails {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="USER_ID")
  private int userId;
  
  @Column(name="USER_NAME")
  private String userName;
 
  
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
