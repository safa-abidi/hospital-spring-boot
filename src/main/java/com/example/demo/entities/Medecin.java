package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
@DiscriminatorValue("medecin")

@Entity
public class Medecin extends Personne{
	@Column(nullable = false)
	private String departement;
	@Column(nullable = false)
	private String specialite;
	
	//relation entre patient et medecin
	@OneToMany(mappedBy = "medecin")
	Set<Consultation> consultations = new HashSet<Consultation>();
}
