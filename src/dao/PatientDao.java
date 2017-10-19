package dao;

import java.util.ArrayList;
import java.util.List;

import models.Patient;

public class PatientDao {
	public Patient getPatientById(int id){
		return null;
	}
	
	public List<Patient> getAllPatients(){
		Patient p1 = new Patient();
		p1.setId(1); p1.setName("pat1");
		
		Patient p2 = new Patient();
		p2.setId(12); p2.setName("pat45");
		List<Patient> patients = new ArrayList<>();
		patients.add(p1); patients.add(p2);
		return patients;
	}
}
