package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long>{

}
