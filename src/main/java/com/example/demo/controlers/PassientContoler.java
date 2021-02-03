package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.PatientRepo;
import com.example.demo.entities.Patient;



@Controller
@RequestMapping(value="/patient")
public class PassientContoler {
	@Autowired
	PatientRepo patient;
	
	@GetMapping(value="/Clients")
	public String allPatients(Model model) {
		List<Patient> pa=patient.findAll();
		model.addAttribute(pa);
		
		return "patients";
	}

}
