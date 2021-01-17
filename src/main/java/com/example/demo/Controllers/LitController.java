package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.LitRepository;
import com.example.demo.entities.Lit;

@Controller
@RequestMapping(value="lits")
public class LitController {
	@Autowired
	LitRepository lit;
	
	@GetMapping("/liste")
	public String act1(Model model) {
		List<Lit> lits = lit.findAll();
		model.addAttribute("listeLits", lits);
		return "listerLits";
	}

	@GetMapping("/ajouter")
	public String act2(Model model) {
		Lit l = new Lit();
		model.addAttribute("lit", l);
		return "ajouterLit.html";
	}
	
	@PostMapping("/sauvegarder")
	public String act3(Lit l) {
		lit.save(l);
		return "redirect:liste";
	}
	
}
