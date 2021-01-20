package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ChambreRepository;
import com.example.demo.dao.LitRepository;
import com.example.demo.dao.TypeRepository;
import com.example.demo.entities.Chambre;
import com.example.demo.entities.Lit;
import com.example.demo.entities.TypeLit;

@Controller
@RequestMapping(value="lits")
public class LitController {
	@Autowired
	LitRepository lit;
	@Autowired 
	ChambreRepository chambres;
	@Autowired 
	TypeRepository types;
	
	@GetMapping("/liste")
	public String act1(Model model) {
		List<Lit> lits = lit.findAll();
		model.addAttribute("listeLits", lits);
		return "listerLits";
	}

	@GetMapping("/ajouter")
	public String act2(Model model) {
		Lit l = new Lit();
		
		List<Chambre> chamb = chambres.findAll();
		model.addAttribute("list_chambres", chamb);
		
		List<TypeLit> type_lit = types.findAll();
		model.addAttribute("list_types", type_lit);
		
		model.addAttribute("lit", l);
		return "ajouterLit";
	}
	
	@PostMapping("/sauvegarder")
	public String act3(Lit l) {
		System.out.println(l.getChambre().getDepartement());
		lit.save(l);
		return "redirect:liste";
	}
	
}
