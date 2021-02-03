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

import com.example.demo.dao.MedecinRepository;
import com.example.demo.entities.Medecin;

@Controller
@RequestMapping(value="medecins")
public class MedecinController {
	@Autowired
	MedecinRepository medecin;
	
	@GetMapping("/liste")
	public String act1(Model model, @RequestParam(name="page" , defaultValue = "0") int p ) {
		Page<Medecin> medecins = medecin.findAll(PageRequest.of(p,5));
		model.addAttribute("pages_medecins", medecins);
		int nb_pages = medecins.getTotalPages();
		int pages[] = new int[nb_pages];
		for(int i = 0 ; i<nb_pages ; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		
		return "listerMedecins.html";
	}
	
	//ajout
		@GetMapping("/ajouter")
		public String act2(Model model) {
			Medecin m = new Medecin();
			model.addAttribute("medecin", m);
			model.addAttribute("what_to_do", "Ajouter ");
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
		//modification
		@GetMapping("/modif_M")
		public String act5(@RequestParam(name="cin")Long idm,Model model) {
			Medecin m =	medecin.getOne(idm);
			model.addAttribute("medecin", m);
			model.addAttribute("what_to_do", "Modifier ");
			return "ajouterMedecin.html";
		}
		
}
