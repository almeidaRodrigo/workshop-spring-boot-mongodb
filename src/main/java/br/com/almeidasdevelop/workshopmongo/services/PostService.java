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

	public Post findById(String id) {
		Optional<Post> findById = repo.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException("Objeto não localizado"));
	}
	
	public List<Post> findByTitle(String title) {
		return repo.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Post> insertAll(List<Post> posts) {
		return repo.insert(posts);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	
}
