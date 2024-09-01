package com.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.model.Patient;
import com.service.PatientService;
import com.service.PatientServiceImpl;

public class PatientMain {

	static PatientService patientService = new PatientServiceImpl();
	static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			System.out.println("----------------------------------");
			System.out.println("1. Add patient");
			System.out.println("2. Show patient List");
			System.out.println("3. Delete patient List");
			System.out.println("4. Update patient List");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			switch(Integer.parseInt(bufferReader.readLine())) {
			case 1: 
				addBtn();
				break;
			case 2:
				listBtn();
				break;
			case 3:
				deleteBtn();
				break;
			case 4:
				updateBtn();
				break;
			case 5:
				System.out.println("--------------Thank you for your time--------------");
				System.exit(0);
			default:
				System.out.println("Enter a valid choice!!");
				break;
			}
		}
//		addBtn();
//		listBtn();
//		updateBtn();
	}
	static void addBtn() throws IOException {
		char flag = 'y';
		do {
			Patient patient = new Patient();
			
			System.out.println("Enter patient name: ");
		    patient.setName(bufferReader.readLine());
		    System.out.println("Enter patient age: ");
		    patient.setAge(Integer.parseInt(bufferReader.readLine()));
		    System.out.println("Enter patient phone number: ");
		    patient.setPhone(bufferReader.readLine());
		    System.out.println("Enter patient address: ");
		    patient.setAddress(bufferReader.readLine());
		    System.out.println("Enter appointed room: ");
		    patient.setAppointedRoom(Integer.parseInt(bufferReader.readLine()));
		
		    patientService.addPatient(patient);
		
		    System.out.println("Do you want to add more y/n ?");
		
		    flag = bufferReader.readLine().charAt(0);
		}while(flag =='y');
	}
	
	static void listBtn() {
		System.out.println("-----List of Patient-----");
		patientService.getAllPatients();
	}
	
	static void deleteBtn() throws NumberFormatException, IOException {
		System.out.println("Enter patient id to delete.");
		patientService.deletePatient(Integer.parseInt(bufferReader.readLine()));
	}
	
	static void updateBtn() throws NumberFormatException, IOException {
		System.out.println("Enter id to update patient:");
		patientService.updatePatient(Integer.parseInt(bufferReader.readLine()));
	}
}
