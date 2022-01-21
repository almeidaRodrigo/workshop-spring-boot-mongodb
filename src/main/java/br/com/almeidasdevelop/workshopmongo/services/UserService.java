package br.com.almeidasdevelop.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almeidasdevelop.workshopmongo.domain.User;
import br.com.almeidasdevelop.workshopmongo.dto.UserDTO;
import br.com.almeidasdevelop.workshopmongo.repository.UserRepository;
import br.com.almeidasdevelop.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> findById = repo.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException("Objeto não localizado"));
	}
	
	public List<User> insertAll(List<User> users) {
		return repo.insert(users);
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteById(String id) {
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(), objDTO.getEmail());
	}

}
