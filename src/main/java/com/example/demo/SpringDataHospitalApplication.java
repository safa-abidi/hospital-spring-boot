package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.AdminRepository;
import com.example.demo.dao.ChambreRepository;
import com.example.demo.dao.TypeRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Chambre;
import com.example.demo.entities.TypeLit;

@SpringBootApplication
public class SpringDataHospitalApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringDataHospitalApplication.class, args);
		
		ApplicationContext ctx = SpringApplication.run(SpringDataHospitalApplication.class,args);
		
		// admin
		AdminRepository ar = ctx.getBean(AdminRepository.class);
		ar.save( new Admin("Ahmed", "Ayari", "12345678", "AhmedAyari@gmail.com", "admin", "admin"));
		
		// chambres
		ChambreRepository ch = ctx.getBean(ChambreRepository.class);
		Chambre c1 = new Chambre("C10");
		ch.save(c1);
		Chambre c2 = new Chambre("C10");
		ch.save(c2);
		Chambre c3 = new Chambre("B12");
		ch.save(c3);
		Chambre c4 = new Chambre("B12");
		ch.save(c4);
		Chambre c5 = new Chambre("A20");
		ch.save(c5);
		
		// types Lit
		TypeRepository tp = ctx.getBean(TypeRepository.class);
		TypeLit t1 = new TypeLit("Lit médicalisé Alzheimer" , 25);
		tp.save(t1);
		TypeLit t2 = new TypeLit("Lit de soins intensifs" , 20);
		tp.save(t2);
		TypeLit t3 = new TypeLit("lit médicalisé électrique" , 30);
		tp.save(t3);
		TypeLit t4 = new TypeLit("lit médicalisé enfant " , 10);
		tp.save(t4);
		
		
		
		
		
		
	}

}
