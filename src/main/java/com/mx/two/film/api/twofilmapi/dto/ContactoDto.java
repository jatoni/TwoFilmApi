package com.mx.two.film.api.twofilmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactoDto {
	private Long id;
	private String nombreContacto;
	private String email;
	private String telefono;
	private String idea;
	private Boolean revisado;
}
