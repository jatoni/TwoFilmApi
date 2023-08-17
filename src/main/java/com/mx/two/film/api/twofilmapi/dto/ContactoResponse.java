package com.mx.two.film.api.twofilmapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactoResponse {
	
	private List<ContactoDto> contenido;
	private int pageNo;
	private int pageSize;
	private Long totalElementos;
	private int totalPages;
	private boolean last;
}
