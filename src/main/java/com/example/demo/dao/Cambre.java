package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Chambre;
public interface Cambre extends JpaRepository<Chambre,Long>{
	@Autowired 
	List<Chambre> findByNumero(int num);

}
