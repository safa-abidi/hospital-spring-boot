package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity
public class TypeLit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeLitId;
	private String libelle;
	@Column(nullable = false)
	private double prixType;
	
	//relation entre lit et type lit
	@OneToMany(mappedBy = "typeLit")
	Set<Lit> lits = new HashSet<Lit>();

}
