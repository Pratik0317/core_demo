package com.service;

import java.io.IOException;
import java.util.List;

import com.model.Patient;

public interface PatientService {

	void addPatient(Patient patient);
	void deletePatient(int id);
	void updatePatient(int id) throws IOException;
	List<Patient> getAllPatients();
}
