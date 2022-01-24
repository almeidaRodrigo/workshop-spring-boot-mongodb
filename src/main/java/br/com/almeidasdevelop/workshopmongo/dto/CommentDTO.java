package br.com.almeidasdevelop.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private LocalDate date;
	private AuthorDTO author;
	
	public CommentDTO() {}

	public CommentDTO(String text, LocalDate date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		return Objects.equals(text, other.text);
	}

	
}
