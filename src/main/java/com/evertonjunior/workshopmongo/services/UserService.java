package com.evertonjunior.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonjunior.workshopmongo.domain.User;
import com.evertonjunior.workshopmongo.dto.UserDTO;
import com.evertonjunior.workshopmongo.repository.UserRepository;
import com.evertonjunior.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(),obj.getEmail());
	}

}
