package com.ganesh.hibernate.basic;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

  @Column(name = "STREET")
  private String street;
  @Column(name = "CITY")
  private String city;
  @Column(name = "PIN")
  private int pin;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getPin() {
    return pin;
  }

  public void setPin(int pin) {
    this.pin = pin;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }



}
