package com.mx.two.film.api.twofilmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.two.film.api.twofilmapi.dto.ContactoDto;
import com.mx.two.film.api.twofilmapi.dto.ResponseExito;
import com.mx.two.film.api.twofilmapi.service.ContactoService;

@RestController
@RequestMapping("/v1/api/contacto")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;

	@PostMapping
	public ResponseEntity<ResponseExito> createContacto(@RequestBody ContactoDto contactoDto) {
		return ResponseEntity.ok(new ResponseExito(200, contactoService.createContacto(contactoDto)));
	}
}
