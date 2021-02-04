
package com.example.demo.controlers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dao.Cambre;
import com.example.demo.entities.Chambre;

@Controller


@RequestMapping(value="/chambre")
public class ChambreControler {
	@Autowired
	Cambre cr;
	
	
	@RequestMapping(value="/liste")
	public String afficherChambres(Model model) {
		List<Chambre> liste = cr.findAll();
		model.addAttribute("liste",liste);
		return "tous-chambres.html";
	}
	@RequestMapping(value="/addChambre", method=RequestMethod.GET)
	public String ajoutChambre(Model model) {
		Chambre ch = new Chambre();
		model.addAttribute("c",ch);
		return "ajout-chambre.html";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveChambret(@Valid Chambre c, BindingResult bindingResult, Model model){		
		if(bindingResult.hasErrors()) {
			System.out.println("errors = " + bindingResult.getAllErrors());
			model.addAttribute("chambre", c);	
			
			return "redirect:addChambre";
		}
		List<Chambre> kr =cr.findByNumero(c.getNumero());
		if (kr.isEmpty()) {
			cr.save(c);
			
		}else {
			String msg ="la chambre existe deja";
			model.addAttribute("error", msg);
		}
		return "redirect:liste";			
	}
	
	@RequestMapping(value="/suprimer")
	public String suprimer_chambre(Model model, @RequestParam(name="id", defaultValue="0")long id){
		cr.deleteById(id);
		
		return "redirect:liste";		
	}
	@RequestMapping(value="/afficherChambre", method=RequestMethod.GET)
	public String afficherChambre(Model model,@RequestParam(name="id", defaultValue="1")long id) {
		Optional<Chambre> c = cr.findById(id);
		model.addAttribute("chambre", c);		
		System.out.println(c);
		return "afficher_chambre.html";		
	}
	@RequestMapping(value="/modifier", method=RequestMethod.POST)
	public String modifierClient(Model model, Chambre c) {
		cr.save(c);
		
		return "redirect:liste";		
	}	
	
	
}
