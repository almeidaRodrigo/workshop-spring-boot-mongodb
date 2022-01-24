package br.com.almeidasdevelop.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.almeidasdevelop.workshopmongo.domain.Post;
import br.com.almeidasdevelop.workshopmongo.domain.User;
import br.com.almeidasdevelop.workshopmongo.dto.AuthorDTO;
import br.com.almeidasdevelop.workshopmongo.services.PostService;
import br.com.almeidasdevelop.workshopmongo.services.UserService;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;

	@Override
	public void run(String... args) throws Exception {
		userService.deleteAll();
		postService.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
				
		userService.insertAll(Arrays.asList(maria, alex, bob));
		
		AuthorDTO authorDTO = new AuthorDTO(maria);
		Post post1 = new Post(null, LocalDate.of(2018, 3, 21), "Partiu viagem", "Vou viajar para São Paulo. Abraços!!!", authorDTO);
		Post post2 = new Post(null, LocalDate.of(2018, 3, 23), "Bom dia", "Acordei feliz hoje!", authorDTO);
		
		postService.insertAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userService.update(maria);
		
	}

}
