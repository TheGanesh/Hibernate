package com.ganesh.hibernate.basic;

import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;

@Entity
@SelectBeforeUpdate
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
  private Address homeAddress;
  
  
  @AttributeOverrides({
    
    @AttributeOverride(name="street",column=@Column(name="OFFICE_STREET")),
    @AttributeOverride(name="city",column=@Column(name="OFFICE_CITY")),
    @AttributeOverride(name="pin",column=@Column(name="OFFICE_PIN"))
    
  })
  @Embedded
  private Address officeAddress; 
  
  @ElementCollection(fetch=FetchType.EAGER)
  @JoinTable(name="USER_ADDRESS",
  joinColumns = @JoinColumn(name="USER_ID")
  )
  
  @GenericGenerator(name="hilo-gen",strategy="hilo")
  @CollectionId(columns={@Column(name="ADDRESS_ID")}, generator = "hilo-gen", type = @Type(type="long"))
  private Collection<Address> listOfAddresses;
  
  
  public Collection<Address> getListOfAddresses() {
    return listOfAddresses;
  }
  public void setListOfAddresses(Collection<Address> listOfAddresses) {
    this.listOfAddresses = listOfAddresses;
  }
  public Address getHomeAddress() {
    return homeAddress;
  }
  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }
  public Address getOfficeAddress() {
    return officeAddress;
  }
  public void setOfficeAddress(Address officeAddress) {
    this.officeAddress = officeAddress;
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
