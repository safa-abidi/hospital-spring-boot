package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity


public class PatientLit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_allocation;
	
	private Date dateDebut;
	private Date dateFin;
	
	private double prixTotal;
	

	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	

	@ManyToOne
	@JoinColumn(name = "litId")
	private Lit lit;


	public PatientLit( Patient patient, Lit lit) {
		super();
		this.dateDebut = new Date();
		this.patient = patient;
		this.lit = lit;
	}
	
	

}
