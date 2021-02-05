package com.example.demo.controlers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PatientRepo;
import com.example.demo.entities.Patient;



@Controller
@RequestMapping(value="/patient")
public class PassientContoler {
	@Autowired
	PatientRepo patient;
	
	@GetMapping(value="/allPatients")
	public String allPatients(Model model) {
		List<Patient> pa=patient.findAll();
		model.addAttribute("pa",pa);
		
		return "patients";
		
	}
	@RequestMapping(value="/addPatient", method=RequestMethod.GET)
	public String ajoutChambre(Model model) {
		Patient pa = new Patient();
		model.addAttribute("p",pa);
		return "ajoutPatient";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveChambret(@Valid Patient p, BindingResult bindingResult, Model model){		
		if(bindingResult.hasErrors()) {
			System.out.println("errors = " + bindingResult.getAllErrors());
			model.addAttribute("pa", p);	
			
			return "redirect:addPatient";
		}
		Optional<Patient> kr =patient.findById(p.getCin());
		if (kr.isEmpty()) {
			patient.save(p);
			
		}else {
			String msg ="la chambre existe deja";
			model.addAttribute("error", msg);
		}
		return "redirect:allPatients";			
	}
	
	@RequestMapping(value="/suprimer")
	public String suprimer_chambre(Model model, @RequestParam(name="id")long id){
		patient.deleteById(id);
		
		return "redirect:allPatients";		
	}
	@RequestMapping(value="/patientDetail", method=RequestMethod.GET)
	public String afficherChambre(Model model,@RequestParam(name="id", defaultValue="1")long id) {
		Patient pa = patient.findById(id).get();
		model.addAttribute("p", pa);		
		System.out.println(pa);
		return "afficher_patient.html";		
	}
	@RequestMapping(value="/modifier", method=RequestMethod.POST)
	public String modifierClient(Model model, Patient c) {
		Patient pa= patient.findById(c.getCin()).get();
		pa=c;
		System.out.println(c);
		
	patient.save(pa);
	System.out.println(pa);
		
		return "redirect:allPatients";		
	}	
	

}
