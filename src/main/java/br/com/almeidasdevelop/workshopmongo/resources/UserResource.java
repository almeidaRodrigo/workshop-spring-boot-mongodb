package br.com.almeidasdevelop.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.almeidasdevelop.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = new ArrayList<User>();
		
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User joao  = new User("2", "Jõao Silva", "joao@gmail.com");
		
		users.addAll(Arrays.asList(maria,joao));
				
		return ResponseEntity.ok().body(users);
	}

}
