package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity


public class Consultation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_consultation;
	
	private Date dateConsultaion;
	private String description;
	

	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	

	@ManyToOne
	@JoinColumn(name = "medecinId")
	private Medecin medecin;

}
