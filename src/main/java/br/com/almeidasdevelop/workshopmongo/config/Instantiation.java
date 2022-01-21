package br.com.almeidasdevelop.workshopmongo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.almeidasdevelop.workshopmongo.domain.User;
import br.com.almeidasdevelop.workshopmongo.services.UserService;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		userService.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
				
		userService.salveAll(Arrays.asList(maria, alex, bob));
	}

}
