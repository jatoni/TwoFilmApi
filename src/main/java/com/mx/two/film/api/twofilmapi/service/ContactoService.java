package com.mx.two.film.api.twofilmapi.service;

import com.mx.two.film.api.twofilmapi.dto.ContactoDto;
import com.mx.two.film.api.twofilmapi.dto.ContactoResponse;

public interface ContactoService {

	String createContacto(ContactoDto contactoDto);

	ContactoResponse getAllContactanos(int pageNo, int pageSize, String sortBy, String sortDir);

	void updateContacto(ContactoDto contactoDto, Long id);
	
	ContactoDto getContacto(Long id);
}
