package com.ganesh.hibernate.basic;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

  @Column(name = "STREET")
  private String street;
  @Column(name = "APT")
  private String apt;  

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getApt() {
    return apt;
  }

  public void setApt(String apt) {
    this.apt = apt;
  }

}
