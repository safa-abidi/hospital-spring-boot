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
	@Column(nullable = false, updatable = false)
	private String login;
	@Column(nullable = false, updatable = false)
	private String password;
}
