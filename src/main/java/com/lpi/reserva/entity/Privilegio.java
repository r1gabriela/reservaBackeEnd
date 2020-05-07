package com.lpi.reserva.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "privilegio")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Privilegio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5859448383879707861L;
	
	@Id
	@Column(name="idprivilegio", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 255, nullable = false)
	private String nome;
	
	@Column(name = "url", length = 255, nullable = false)
	private String url;
	
    @ManyToMany(mappedBy = "privilegios")
    private ArrayList<Role> roles;
    
}
