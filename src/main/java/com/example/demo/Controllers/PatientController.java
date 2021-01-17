package com.example.demo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;


@Controller
@RequestMapping(value="patients")
public class PatientController {
	@Autowired
	PatientRepository patient;
	
	@GetMapping("/liste")
	public String act1(Model model) {
		List<Patient> patients = patient.findAll();
		model.addAttribute("listePatients", patients);
		return "listerPatients.html";
	}
	
	@GetMapping("/ajouter")
	public String act2(Model model) {
		Patient p = new Patient();
		model.addAttribute("patient", p);
		return "ajouterPatient.html";
	}
	
	@PostMapping("/sauvegarder")
	public String act3(Patient p) {
		System.out.println(p);
		patient.save(p);
		return "redirect:liste";
	}
	
	//suppression
		@GetMapping("/supp")
		public String act4(@RequestParam(name="cin")Long idp) {
			patient.deleteById(idp);
			return "redirect:liste";
		}
	

	

}
