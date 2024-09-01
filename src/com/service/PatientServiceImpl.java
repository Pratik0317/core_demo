package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.PatientDB;
import com.model.Patient;

public class PatientServiceImpl implements PatientService {
	
	@Override
	public void addPatient(Patient patient) {
		String sql = "INSERT INTO patient(name,age,phone,address,appointedRoom)VALUES(?,?,?,?,?)";
		
		try {
			PreparedStatement ptms = PatientDB.getConnect().prepareStatement(sql);
			ptms.setString(1, patient.getName());
			ptms.setInt(2, patient.getAge());
			ptms.setString(3, patient.getPhone());
			ptms.setString(4, patient.getAddress());
			ptms.setInt(5, patient.getAppointedRoom());
			
			ptms.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePatient(int id) {
		String sql = "DELETE FROM patient WHERE pid = ?";
		
		try {
			PreparedStatement ptms = PatientDB.getConnect().prepareStatement(sql);
			ptms.setInt(1, id);
			int rowAffected = ptms.executeUpdate();
			if(rowAffected>0) {
				System.out.println("Record with id "+id+" deleted successfully.");
			}else {
				System.out.println("Record with id "+id+" not found.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePatient(int id) throws IOException {
		
		String updateQuery = "UPDATE patient SET name = ?, age = ?, phone = ?, address = ?, appointedRoom = ? WHERE pid = ?";
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			PreparedStatement ptms = PatientDB.getConnect().prepareStatement(updateQuery);
			System.out.println("Enter patient name");
			ptms.setString(1, bufferedReader.readLine());
			System.out.println("Enter patient age");
			ptms.setInt(2, Integer.parseInt(bufferedReader.readLine()));
			System.out.println("Enter phone");
			ptms.setString(3, bufferedReader.readLine());
			System.out.println("Enter address");
			ptms.setString(4, bufferedReader.readLine());
			System.out.println("Enter appointed room");
			ptms.setInt(5, Integer.parseInt(bufferedReader.readLine()));
			ptms.setInt(6, id);
			int rowsAffected = ptms.executeUpdate();
			
			if (rowsAffected > 0) {
	            System.out.println("Book with id " + id + " updated successfully.");
	        } else {
	            System.out.println("No book found with id " + id + ".");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Patient> getAllPatients() {
		
		String sql = "SELECT*FROM patient";
		
		List<Patient> patientList = new ArrayList<>();
		
		try {
			PreparedStatement ptms = PatientDB.getConnect().prepareStatement(sql);
			ResultSet resultSet = ptms.executeQuery();
			while(resultSet.next()) {
				int pid = resultSet.getInt("pid");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				int appointedRoom = resultSet.getInt("appointedRoom");
				System.out.println("Patient ID: "+pid+" Patient Name: "+name+" Age: "+age+
						" Phone: "+phone+" Address: "+address+" Appointed room: "+appointedRoom);
				
				Patient patient = new Patient(pid, name, age, phone, address, appointedRoom);
				patientList.add(patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patientList;
	}

}
