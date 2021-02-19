package dev.jaon.library.api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.jaon.library.api.model.Author;
import dev.jaon.library.api.model.Book;

@Service
public class AuthorsService {
	private final String apiUrl = "https://bibliapp.herokuapp.com/api/authors";

	public Author[] findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Author[] authors = restTemplate.getForObject(apiUrl, Author[].class);
		return authors;
	}

	public Author findOne(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Author author = restTemplate.getForObject(apiUrl + "/" + id, Author.class);
		return author;
	}

	public Author create(Author author) {
		RestTemplate restTemplate = new RestTemplate();
		Author createdAuthor = restTemplate.postForObject(apiUrl, author, Author.class);
		return createdAuthor;
	}

	public ResponseEntity<Author> update(Author author) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Author> requestUpdate = new HttpEntity<>(author);
		ResponseEntity<Author> response = restTemplate.exchange(apiUrl + "/" + author.getId(), HttpMethod.PUT,
				requestUpdate, Author.class);
		return response;
	}

	public void delete(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(apiUrl + "/" + id);
	}

	public Book[] getAuthorBooks(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Book[] books = restTemplate.getForObject(apiUrl + "/" + id + "/books", Book[].class);
		return books;
	}
}
