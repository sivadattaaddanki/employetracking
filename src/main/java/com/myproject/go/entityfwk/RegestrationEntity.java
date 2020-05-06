package com.myproject.go.entityfwk;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users_details")
public class RegestrationEntity {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	private String userName;
	private String password;
	private LocalDate dob;
	private String emailId;
	private Integer phoneNumber;
	private Integer aadharNumber;
	private String panNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", unique = true )
	private AddressEntity addressDetails;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private List<UserAttendance>  attendance;

	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Integer getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Integer aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public AddressEntity getAddress() {
		return addressDetails;
	}
	public void setAddress(AddressEntity address) {
		this.addressDetails = address;
	}
	public List<UserAttendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(List<UserAttendance> attendance) {
		this.attendance = attendance;
	}


}
