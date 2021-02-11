package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor

//jpa
@DiscriminatorValue("admin")

@Entity
public class Admin extends Personne{
	@Column( updatable = false)
	private String login;
	@Column( updatable = false)
	private String password;
	
	
	
	public Admin( String nom, String prenom, String tel, String email, String login, String password) {
		super( nom, prenom, tel, email);
		this.login = login;
		this.password = password;
	}
	
	
}
