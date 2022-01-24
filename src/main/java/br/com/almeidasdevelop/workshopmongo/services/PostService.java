package br.com.almeidasdevelop.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almeidasdevelop.workshopmongo.domain.Post;
import br.com.almeidasdevelop.workshopmongo.repository.PostRepository;
import br.com.almeidasdevelop.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;

	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> findById = repo.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException("Objeto não localizado"));
	}
	
	public List<Post> insertAll(List<Post> posts) {
		return repo.insert(posts);
	}
	
	public Post insert(Post post) {
		return repo.insert(post);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteById(String id) {
		repo.deleteById(id);
	}
}
