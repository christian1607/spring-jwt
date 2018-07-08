package com.celmam.apisistradoc.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class User implements Comparable<User>{

	
	private String username;
	private String password;
	
	
	
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.getUsername().compareTo(o.getUsername());
	}

	
}
