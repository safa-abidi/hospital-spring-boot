package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ChambreRepository;
import com.example.demo.entities.Chambre;

@Controller
@RequestMapping(value="chambres")
public class ChambreController {
	@Autowired
	ChambreRepository chambre;
	
	@GetMapping("/liste")
	public String act1(Model model) {
		List<Chambre> chambres = chambre.findAll();
		model.addAttribute("listeChambres", chambres);
		return "listerChambres";
	}

}
