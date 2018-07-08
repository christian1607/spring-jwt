package com.celmam.apisistradoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celmam.apisistradoc.entity.Persona;

@RestController
@RequestMapping(path = "/persona")
public class DocumentosController {

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllDocumento() { 

		List<Persona> documentos = new ArrayList<>();
		documentos.add(new Persona("Christian", "Altamirano Ayala", 25));
		documentos.add(new Persona("Lucero", "Altamirano Ayala", 22));
		documentos.add(new Persona("Yamile", "Altamirano Ayala",23));
		return new ResponseEntity<List<Persona>>(documentos, HttpStatus.OK);

	}

}
