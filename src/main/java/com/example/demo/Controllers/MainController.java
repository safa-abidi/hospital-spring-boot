package com.example.demo.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Medecin;

@Controller
public class MainController {
	
	@Autowired
	AdminRepository admin;
	
	@GetMapping("/")
	public String act1() {
		return "signin";
	}
	
	@GetMapping("/home")
	public String act3() {
		return "index";
	}
	
	@PostMapping("/home_page")
	public String act2(@RequestParam(name="login") String login , @RequestParam(name="password") String password ,HttpServletRequest request ) {
	
		List<Admin> admins = admin.findAll();
		for(Admin val : admins) {
			if(val.getLogin().equals(login) && val.getPassword().equals(password)) {
				HttpSession s = request.getSession(true);
				s.setAttribute("admin", val);
				System.out.println("welcome " + login);
				return "index";
			}
		}
		return "signin";
	}

}


