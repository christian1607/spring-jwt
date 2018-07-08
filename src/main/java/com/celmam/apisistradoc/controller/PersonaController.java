package com.celmam.apisistradoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celmam.apisistradoc.entity.Documento;
import com.celmam.apisistradoc.entity.TipoDocumento;

@RestController
@RequestMapping(path = "/documento")
public class PersonaController {

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllDocumento() { 

		List<Documento> documentos = new ArrayList<>();
		documentos.add(new Documento("1", "Oficio Nro 123-2018", new TipoDocumento("1", "oficio")));
		documentos.add(new Documento("2", "Oficio Nro 12-2018", new TipoDocumento("1", "oficio")));
		documentos.add(new Documento("3", "Oficio Nro 12-2018", new TipoDocumento("1", "oficio")));
		return new ResponseEntity<List<Documento>>(documentos, HttpStatus.OK);

	}

}
