package com.mx.two.film.api.twofilmapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.two.film.api.twofilmapi.dto.ContactoDto;
import com.mx.two.film.api.twofilmapi.dto.ContactoResponse;
import com.mx.two.film.api.twofilmapi.entity.Contacto;
import com.mx.two.film.api.twofilmapi.exception.ResourceNotFoundException;
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

	@Override
	public ContactoResponse getAllContactanos(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pegable = PageRequest.of(pageNo, pageSize, sort);

		Page<Contacto> contactos = contactoRepository.findAll(pegable);

		List<Contacto> listOfContactos = contactos.getContent();

		List<ContactoDto> content = listOfContactos.stream().map(contacto -> mapper.map(contacto, ContactoDto.class))
				.collect(Collectors.toList());

		ContactoResponse contactoResponse = new ContactoResponse();

		contactoResponse.setContenido(content);
		contactoResponse.setPageNo(contactos.getNumber());
		contactoResponse.setPageSize(contactos.getSize());
		contactoResponse.setTotalElementos(contactos.getTotalElements());
		contactoResponse.setTotalPages(contactos.getTotalPages());
		contactoResponse.setLast(contactos.isLast());

		return contactoResponse;
	}

	@Override
	public void updateContacto(ContactoDto contactoDto, Long id) {
		Contacto contacto = contactoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contactanos", "id", id));

		contacto.setEmail(contactoDto.getEmail());
		contacto.setNombreContacto(contactoDto.getNombreContacto());
		contacto.setTelefono(contactoDto.getTelefono());
		contacto.setIdea(contactoDto.getIdea());
		contacto.setRevisado(contactoDto.getRevisado());
		contactoRepository.save(contacto);
	}

}
