package com.celmam.apisistradoc.service;

import com.celmam.apisistradoc.entity.User;

public interface UserService {

	public User findOne(String username);

	public void save(User user);

}
