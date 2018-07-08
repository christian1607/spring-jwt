package com.celmam.apisistradoc.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Documento   {

	
	private String id;
	private String nombre;
	private TipoDocumento tipoDocumento;
	
	 
	
}
