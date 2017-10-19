package services;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PatientDao;
import models.Patient;

@Path("/PatientService")
public class PatientService {
	PatientDao patientDao = new PatientDao();
	
	@GET
	@Path("/patients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getAllPatients(){
		return patientDao.getAllPatients();
	}
	
	@GET
	@Path("/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatientById(int id){
		return patientDao.getPatientById(id);
	}
	
	
}
