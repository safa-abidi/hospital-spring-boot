package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="lit")
public class Lit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long litId;
	@Column(nullable = false)
	private boolean etat;
	
	//relation entre lit et type lit
	@ManyToOne()
	@JoinColumn(name="typeLitId")
	private TypeLit typeLit;
	
	//relation entre lit et chambre
	@ManyToOne
	@JoinColumn(name = "chambreId")
	private Chambre chambre;
	
	//relation entre patient et lit
	@OneToMany(mappedBy = "lit")
	Set<PatientLit> patientsLits = new HashSet<PatientLit>();
	
	public boolean Get_etat() {
		return this.etat;
	}
	
	public void Set_etat(boolean etat) {
		this.etat=etat;
	}
	
}
