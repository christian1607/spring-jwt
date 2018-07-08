package com.celmam.apisistradoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celmam.apisistradoc.config.JwtTokenUtil;
import com.celmam.apisistradoc.entity.AuthToken;
import com.celmam.apisistradoc.entity.LoginUser;
import com.celmam.apisistradoc.entity.User;
import com.celmam.apisistradoc.service.UserService;

@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService usersService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

		UsernamePasswordAuthenticationToken credencial = new UsernamePasswordAuthenticationToken(
				loginUser.getUsername(), loginUser.getPassword());

		final Authentication authentication = authenticationManager.authenticate(credencial);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		final User user = usersService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);

		return ResponseEntity.ok(new AuthToken(token));
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody User user) throws AuthenticationException {

		usersService.save(user);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
