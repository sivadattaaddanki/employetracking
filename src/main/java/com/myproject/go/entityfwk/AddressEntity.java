package com.myproject.go.entityfwk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userAddressDetails")
public class AddressEntity {
@Id
@GeneratedValue
private Long addressId;
private String firstLine;
public Long getAddressid() {
	return addressId;
}
public void setAddressid(Long addressId) {
	this.addressId = addressId;
}
public String getFirstLine() {
	return firstLine;
}
public void setFirstLine(String firstLine) {
	this.firstLine = firstLine;
}
public String getSecondLine() {
	return secondLine;
}
public void setSecondLine(String secondLine) {
	this.secondLine = secondLine;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
private String secondLine;
private String district;
private String state;
private int pincode;
}
