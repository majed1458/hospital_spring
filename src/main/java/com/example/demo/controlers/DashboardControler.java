package com.example.demo.controlers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Chambre;

@Controller

@RequestMapping(value="/")
public class DashboardControler {
	@RequestMapping(value="/")
	public String all() {
	
		return "all.html";
	}
}
