package br.com.almeidasdevelop.workshopmongo.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.almeidasdevelop.workshopmongo.domain.Post;
import br.com.almeidasdevelop.workshopmongo.resources.util.URL;
import br.com.almeidasdevelop.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post postFound = service.findById(id);
		
		return ResponseEntity.ok(postFound);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
		String decodedTitle = URL.decodeParam(title);
		List<Post> postsFound = service.findByTitle(decodedTitle);
		
		return ResponseEntity.ok(postsFound);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "title", defaultValue = "") String title, 
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate){
		String decodedTitle = URL.decodeParam(title);
		LocalDate decodedMinDate = URL.convertDate(minDate, LocalDate.now().minusDays(1));
		LocalDate decodedMaxDate = URL.convertDate(maxDate, LocalDate.now().plusDays(1));
		List<Post> postsFound = service.fullSearch(decodedTitle, decodedMinDate, decodedMaxDate);
		
		return ResponseEntity.ok(postsFound);
	}

}
