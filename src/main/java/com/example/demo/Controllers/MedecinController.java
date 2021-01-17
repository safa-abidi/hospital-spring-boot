package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.MedecinRepository;
import com.example.demo.entities.Medecin;

@Controller
@RequestMapping(value="medecins")
public class MedecinController {
	@Autowired
	MedecinRepository medecin;
	
	@GetMapping("/liste")
	public String act1(Model model) {
		List<Medecin> medecins = medecin.findAll();
		model.addAttribute("listeMedecins", medecins);
		return "listerMedecins.html";
	}
	
	//ajout
		@GetMapping("/ajouter")
		public String act2(Model model) {
			Medecin m = new Medecin();
			model.addAttribute("medecin", m);
			return "ajouterMedecin.html";
		}
		
		@PostMapping("/sauvegarder")
		public String act3(Medecin m) {
			medecin.save(m);
			return "redirect:liste";
		}
		//suppression
		@GetMapping("/supp")
		public String act4(@RequestParam(name="cin")Long idm) {
			medecin.deleteById(idm);
			return "redirect:liste";
		}
		
}
