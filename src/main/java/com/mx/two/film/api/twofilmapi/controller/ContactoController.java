package com.mx.two.film.api.twofilmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.two.film.api.twofilmapi.dto.ContactoDto;
import com.mx.two.film.api.twofilmapi.dto.ContactoResponse;
import com.mx.two.film.api.twofilmapi.dto.ResponseExito;
import com.mx.two.film.api.twofilmapi.service.ContactoService;
import static com.mx.two.film.api.twofilmapi.utils.AppConstants.*;

@RestController
@RequestMapping("/v1/api/contactos")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;

	@GetMapping
	public ContactoResponse getAllContactanos(
			@RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIR, required = false) String sortDir) {

		return contactoService.getAllContactanos(pageNo, pageSize, sortBy, sortDir);
	}

	@PostMapping
	public ResponseEntity<ResponseExito> createContacto(@RequestBody ContactoDto contactoDto) {
		return ResponseEntity.ok(new ResponseExito(200, contactoService.createContacto(contactoDto)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> contactanosRevisado(@RequestBody ContactoDto contacto, @PathVariable("id") Long id) {
		contactoService.updateContacto(contacto, id);
		return ResponseEntity.ok("Se actulizo con exito");
	}
}
