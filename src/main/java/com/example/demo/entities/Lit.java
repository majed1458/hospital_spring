package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lit {
@Id
@Column(name = "lit_id", nullable = false)
 private long id;
@Column(columnDefinition = "boolean default false")
private Boolean chargé ;
@ManyToOne
@JoinColumn(name = "chambreId")
private Chambre chambre;


}
