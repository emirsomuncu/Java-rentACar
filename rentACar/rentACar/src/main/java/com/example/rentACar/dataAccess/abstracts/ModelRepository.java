package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
