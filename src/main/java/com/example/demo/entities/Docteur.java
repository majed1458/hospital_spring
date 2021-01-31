package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="docteur")
public class Docteur extends Personne {
	@ManyToOne()
	@JoinColumn(name = "depId")
	private Departement departement;
	 @Basic
	 @Column(name = "job", nullable = false, length = 16)
    private String job;
	 @OneToMany(mappedBy = "docteur")
	 private Collection<Visite> visites ;
}
