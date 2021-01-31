package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
	 @Id
	 @Column(name = "chambre_id", nullable = false)
     private long id;
	 @Basic
	 @Column(name = "numero", nullable = false)
	 private int numero ;
	 @Basic
	 @Column(name = "capacite", nullable = false)
	 private int capacite ;
	 @OneToMany(mappedBy = "chambre")
	 private Collection<Lit> lits ; 
	 
	 
	 
}
