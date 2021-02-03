package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity
@Table(name="chambre")
public class Chambre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long chambreId;
	
	private String departement;

	//relation entre lit et chambre
	@OneToMany(mappedBy = "chambre")
	Set<Lit> lits = new HashSet<Lit>(); 	
}
