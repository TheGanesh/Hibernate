package com.ganesh.hibernate.many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="VEHICLE")
public class Vehicle {

  @Column(name="VEHICLE_ID")
  @Id @GeneratedValue
  private int vehicleId;
  
  @Column(name="VEHICLE_NAME")
  private String vehicleName;
  
  @ManyToMany
@JoinTable(
    name="USER_VEHICLE",
    joinColumns= @JoinColumn(name="VEHICLE_ID"),
    inverseJoinColumns=@JoinColumn(name="USER_ID"))
  
  private List<UserDetails> usersList = new ArrayList<UserDetails>();
  
 

  public List<UserDetails> getUsersList() {
    return usersList;
  }

  public void setUsersList(List<UserDetails> usersList) {
    this.usersList = usersList;
  }

  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + vehicleId;
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
    Vehicle other = (Vehicle) obj;
    if (vehicleId != other.vehicleId)
      return false;
    return true;
  }
  
  
  
}
