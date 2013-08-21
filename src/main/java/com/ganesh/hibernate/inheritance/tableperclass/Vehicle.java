package com.ganesh.hibernate.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

  @Column(name="VEHICLE_ID")
  @Id @GeneratedValue(strategy=GenerationType.TABLE)
  private int vehicleId;
  
  @Column(name="VEHICLE_NAME")
  private String vehicleName;
  
  
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
