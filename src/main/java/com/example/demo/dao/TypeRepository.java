package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.TypeLit;

public interface TypeRepository extends JpaRepository<TypeLit, Long>{

}
