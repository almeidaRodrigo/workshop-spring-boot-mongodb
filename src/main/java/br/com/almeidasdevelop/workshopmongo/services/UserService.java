package br.com.almeidasdevelop.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almeidasdevelop.workshopmongo.domain.User;
import br.com.almeidasdevelop.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public void salveAll(List<User> users) {
		repo.saveAll(users);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}

}
