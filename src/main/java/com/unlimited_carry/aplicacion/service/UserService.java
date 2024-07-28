package com.unlimited_carry.aplicacion.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.unlimited_carry.aplicacion.Exception.UsernameOrIdNotFound;
import com.unlimited_carry.aplicacion.dto.ChangePasswordForm;
import com.unlimited_carry.aplicacion.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;

	public User updateUser(User user) throws Exception;

	public void deleteUser(Long id) throws UsernameOrIdNotFound;

	public User changePassword(ChangePasswordForm form) throws Exception;
}
