package services;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.PatientDao;
import models.Patient;

@Path("/PatientService")
public class PatientService {
	@Context
	private HttpServletRequest request;
	PatientDao patientDao = new PatientDao();
	
	@GET
	@Path("/patients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getAllPatients(){
		System.out.println("inside getAllPatients");
		return patientDao.getAllPatients();
	}
	
	@GET
	@Path("/patient/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatientById(@PathParam("id") String id){
		System.out.println("inside getPatientById");
		int pid = Integer.parseInt(id);
		return patientDao.getPatientById(pid);
	}
	
	
}
