package com.example.demo.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cin;
	@Basic
	@Column(name = "nom", nullable = false, length = 32,unique = true)
	private String nom;
	
	@Basic
    @Column(name = "prenom", nullable = false, length = 32)
	private String prenom;
	@Basic
    @Column(name = "age", nullable = true)
	private int age ;
	@Column(name = "tel", nullable = false, length = 8)
	@NotNull
	@NotBlank(message="Please enter your phone number")
	private String phoneNumber;
	@NotEmpty
    @Email(message = "mail invalide")
	private String email;
}
