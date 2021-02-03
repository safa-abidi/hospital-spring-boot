package com.example.demo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;


@Controller
@RequestMapping(value="patients")
public class PatientController {
	@Autowired
	PatientRepository patient;
	
	@GetMapping("/liste")
	public String act1(Model model , @RequestParam(name="page" , defaultValue = "0") int p ) {
		Page<Patient> patients = patient.findAll(PageRequest.of(p,5));
		model.addAttribute("Patients_pages", patients);
		int nb_pages = patients.getTotalPages();
		int pages[] = new int[nb_pages];
		for(int i = 0 ; i<nb_pages ; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		
		return "listerPatients.html";
	}
	
	@GetMapping("/ajouter")
	public String act2(Model model) {
		Patient p = new Patient();
		model.addAttribute("patient", p);
		model.addAttribute("what_to_do", "Ajouter ");
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
	
	//modification
		@GetMapping("/modif_P")
		public String act5(@RequestParam(name="cin")Long idp,Model model) {
			Patient p =	patient.getOne(idp);
			model.addAttribute("patient", p);
			model.addAttribute("what_to_do", "Modifier ");
			return "ajouterPatient.html";
		}
	

}
