package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{

}
