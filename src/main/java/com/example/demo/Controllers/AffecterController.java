package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.LitPatRepository;
import com.example.demo.dao.LitRepository;
import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Lit;
import com.example.demo.entities.Patient;
import com.example.demo.entities.PatientLit;

@Controller
public class AffecterController {
	@Autowired
	PatientRepository patient;
	
	@Autowired
	LitRepository lit_bd;
	
	@Autowired
	LitPatRepository lit_pat_bd;
	
	
	@RequestMapping(value="/affecter_page")
	public String act1(Model model) {
		
		
		// TO COLLET ALL THE PATIENS WHO HAVE NO BED
		List<Patient> patients = new ArrayList<Patient>();
		List<Lit> lits = new ArrayList<Lit>();
		
		for(Patient p : patient.findAll()) {
			if(!p.getEtat_patient()) {
				patients.add(p);
			}
		}
		
		// TO COLLET ALL THE EMPTY BEDS
		
		for(Lit l : lit_bd.findAll()) {
			if(!l.Get_etat()) {
				lits.add(l);
			}
		}
		
		System.out.println("*********** nb patients : " + patients.size() + " nb lits : " + lits.size());
		model.addAttribute("listePatients2", patients);
		model.addAttribute("listeLits2", lits);

		return "affecter";
	}
	
	
	@RequestMapping("/affecter")
	public String act2(@RequestParam(name="id_lit") long lit_id , @RequestParam(name="id_Pat") long Pat_id ,Model model) {
		
		System.out.println("id_pat :" + Pat_id + " idl_it" + Pat_id);
		
		Patient pf = patient.getOne(Pat_id);
		Lit lf = lit_bd.getOne(lit_id);
		String message= "";
		
		
		if(pf==null || lf==null) {
			message="Echec d'affectation , réessayer";
		}
		else if(!pf.getEtat_patient() && !lf.Get_etat()) {
			
			PatientLit pat_lit = new PatientLit(pf,lf);
			pf.setEtat_patient(true);
			lf.setEtat(true);
			patient.save(pf);
			lit_bd.save(lf);
			lit_pat_bd.save(pat_lit);
			message= "Affectation avec succès";	
		}
		else {
			message="Echec d'affectation , réessayer";
		}
		model.addAttribute("message", message);
		
		return act1(model);
	}

	@RequestMapping("/Liberer")
	public String liberer_lit(@RequestParam( name="Id") Long id ) {
		
		// changer l'etat du lit
		Lit l = lit_bd.getOne(id);
		l.setEtat(false);
		lit_bd.save(l);
		
		List<PatientLit> pat_lit_list = lit_pat_bd.findAll();
		PatientLit plf = null;
		
		// changer les paratemers du patient_lit
		for( PatientLit pt : pat_lit_list) {
			if(pt.getLit().getLitId() == id && pt.getPrixTotal()==0) {
				plf=pt;
			}
		}
		
		plf.setDateFin(new Date());
		
		System.out.println(plf.getDateDebut().getTime());
		System.out.println(plf.getDateFin().getTime());
		
		long a = plf.getDateDebut().getTime();
		long b = plf.getDateFin().getTime();
		int number_of_days = (int) ((b-a)/(1000*60*60*24)) ;
		plf.setPrixTotal(number_of_days * l.getTypeLit().getPrixType());
		lit_pat_bd.save(plf);
		
		
		// changer l'etat du patient
		
		Patient p = plf.getPatient();
		p.setEtat_patient(false);
		patient.save(p);
		
		
		System.out.println(id);
		
		return "redirect:/lits/liste";
	}
}
