package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Chambre;
import com.example.demo.entities.Lit;

public interface LitRepo extends JpaRepository<Lit, Long>{
	List<Lit> findByChambre(Chambre chambre);
	@Query("SELECT COUNT(*) FROM Lit l WHERE chambre_id=:x")
	int countlit(@Param("x") long id);
	List<Lit> findByChargé(Boolean chargé );
	@Query("SELECT COUNT(*) FROM Lit l WHERE chambre_id=:x AND l.chargé=false")
	int countlitnonchargé(@Param("x") long id);
}
