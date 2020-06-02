package com.lpi.reserva.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
        name = "role_privilegio", 
        joinColumns = @JoinColumn(
          name = "role_idrole", referencedColumnName = "idrole"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilegio_idprivilegio", referencedColumnName = "idprivilegio"))
	private List<Privilegio> privilegios;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
}
