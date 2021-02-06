package com.example.demo.controlers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.Cambre;
import com.example.demo.dao.LitRepo;
import com.example.demo.entities.Chambre;
import com.example.demo.entities.Lit;
import com.example.demo.entities.Patient;

@Controller
@RequestMapping(value="/lit")
public class LitControler {
	LitRepo lit ;
Cambre ch ;

	@GetMapping(value="/chabreLit")
	@RequestMapping(value="/afficherChambre", method=RequestMethod.GET)
	public String ChambreLit(Model model,@RequestParam(name="id", defaultValue="1")long id) {
		Lit c = new Lit();
		
		model.addAttribute("c", c);		
		
		return "affectéLit.html";		
	}
	
	@PostMapping(value="/ajouterLit")
	public String ajouLit(@RequestParam(name="id", defaultValue="1")long id ,Lit l) {
	Chambre ch2=ch.findById(id).get();
	l.setChambre(ch2);
		lit.save(l);
		return "tous-chambres.html";
		
	}
	
}
