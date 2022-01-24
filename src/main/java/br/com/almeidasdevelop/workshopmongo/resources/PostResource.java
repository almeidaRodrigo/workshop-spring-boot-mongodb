package br.com.almeidasdevelop.workshopmongo.resources;

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
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
		return ResponseEntity.ok(service.findByTitle(URL.decodeParam(title)));
	}

}
