package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PatientLit;

public interface LitPatRepository extends JpaRepository<PatientLit, Long>{

}
