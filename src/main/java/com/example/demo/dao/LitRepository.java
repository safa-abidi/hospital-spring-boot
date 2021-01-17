package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Lit;

public interface LitRepository extends JpaRepository<Lit, Long>{

}
