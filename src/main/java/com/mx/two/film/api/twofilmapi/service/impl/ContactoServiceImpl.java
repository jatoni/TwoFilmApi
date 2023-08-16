package com.mx.two.film.api.twofilmapi.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.two.film.api.twofilmapi.dto.ContactoDto;
import com.mx.two.film.api.twofilmapi.entity.Contacto;
import com.mx.two.film.api.twofilmapi.repository.ContactoRepository;
import com.mx.two.film.api.twofilmapi.service.ContactoService;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String createContacto(ContactoDto contactoDto) {
		Contacto contacto = mapper.map(contactoDto, Contacto.class);
		contactoRepository.save(contacto);
		return "Se Registro Su Idea";
	}

}
