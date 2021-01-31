package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Personne {
    @Basic
    @Column(name = "maladie", nullable = true, length = 255)
	private String maladie ;
    @Basic
    @Column(name = "etat", nullable = true, length = 20)
	private String etat ;
    
    
    @OneToMany(mappedBy = "patient")
	 private Collection<Visite> visites ;
    }
