package com.model;

public class Patient {

	private int pid;
	private String name;
	private int age;
	private String phone;
	private String address;
	private int appointedRoom;
	
	public Patient(int pid, String name, int age, String phone, String address, int appointedRoom) {
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.appointedRoom = appointedRoom;
	}

	
	public Patient() {
		
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAppointedRoom() {
		return appointedRoom;
	}

	public void setAppointedRoom(int appointedRoom) {
		this.appointedRoom = appointedRoom;
	}


	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ ", appointedRoom=" + appointedRoom + "]";
	}
	
}
