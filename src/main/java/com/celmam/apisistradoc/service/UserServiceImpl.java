package com.celmam.apisistradoc.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.celmam.apisistradoc.entity.User;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	private static Set<User> usuarios;

	static {
		usuarios = new TreeSet<>();
		usuarios.add(new User("christian", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu"));
	}

	@Override
	public User findOne(String username) {

		return usuarios.stream().filter(p -> p.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User usuario = findOne(username);
		if (null == usuario) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public void save(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		usuarios.add(user);
	}

}
