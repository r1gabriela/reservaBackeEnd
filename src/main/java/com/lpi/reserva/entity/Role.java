package com.lpi.reserva.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Role implements Serializable{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 3981244752147533526L;
	
	@Id
	@Column(name="idrole", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRole;
	
	@Column(name = "nome", length = 255, nullable = false)
	private String nome;
	
	@ManyToMany
    @JoinTable(
        name = "roles_privilegios", 
        joinColumns = @JoinColumn(
          name = "role_idrole", referencedColumnName = "idrole"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilegio_idprivilegio", referencedColumnName = "idprivilegio"))

	private ArrayList<Usuario> usuarios;

}
