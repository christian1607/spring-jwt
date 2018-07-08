package com.celmam.apisistradoc.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditoriaFields {
	
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaActualizacion;

	
	
	

}
