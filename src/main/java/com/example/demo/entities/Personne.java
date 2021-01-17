package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//heritage
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typePersonne", discriminatorType = DiscriminatorType.STRING, length = 10)

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity
@Table(name="personne")
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cin;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String prenom;
	
	@Column(nullable = false)
	private String tel;
	
	private String email;

}
