package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor

//jpa
@DiscriminatorValue("patient")

@Entity
public class Patient extends Personne{
	private String maladie;
	private Boolean etat_patient;
	
	//relation entre patient et lit
	@OneToMany(mappedBy = "patient")
	Set<PatientLit> patientsLits = new HashSet<PatientLit>();
	
	//relation entre patient et medecin
	@OneToMany(mappedBy = "patient")
	Set<Consultation> consultations = new HashSet<Consultation>();
}
