package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Patient;

public class PatientDao {
	private Statement stmt;
	private Connection con;
	private ResultSet rs;
	private String sql;

	public Patient getPatientById(int id) {
		con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM patients WHERE pid=" + id);
			if (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("pid"));
				patient.setFname(rs.getString("fname"));
				patient.setLname(rs.getString("lname"));
				patient.setPhone(rs.getString("phone"));
				patient.setSsn(rs.getString("ssn"));
				return patient;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM patients");
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("pid"));
				patient.setFname(rs.getString("fname"));
				patient.setLname(rs.getString("lname"));
				patient.setPhone(rs.getString("phone"));
				patient.setSsn(rs.getString("ssn"));
				patients.add(patient);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return patients;
	}
}
