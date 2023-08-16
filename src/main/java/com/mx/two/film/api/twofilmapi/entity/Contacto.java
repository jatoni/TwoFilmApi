package com.mx.two.film.api.twofilmapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "contactos")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombreContacto", nullable = false)
	private String nombreContacto;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "idea", nullable = false, length = 500)
	private String idea;

	@Column(name = "revisado", nullable = true)
	private Boolean revisado;
}
