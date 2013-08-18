package com.ganesh.hibernate.one2many;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  private int userId;

  @Column(name = "USER_NAME")
  private String userName;

  @OneToMany
  @JoinTable(
      name="USER_VEHICLE",
      joinColumns=@JoinColumn(name="USER_ID"),
      inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
  
  private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

  public Collection<Vehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(Collection<Vehicle> vehicles) {
    this.vehicles = vehicles;
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
