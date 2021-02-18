package dev.jaon.library.api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.jaon.library.api.model.Book;

@Service
public class BooksService {
	private final String apiUrl = "https://bibliapp.herokuapp.com/api/books";

	public Book[] findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Book[] books = restTemplate.getForObject(apiUrl, Book[].class);
		return books;
	}

	public Book findOne(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject(apiUrl + "/" + id, Book.class);
		return book;
	}

	public Book create(Book book) {
		RestTemplate restTemplate = new RestTemplate();
		Book createdBook = restTemplate.postForObject(apiUrl, book, Book.class);
		return createdBook;
	}

	public ResponseEntity<Book> update(Book book) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Book> requestUpdate = new HttpEntity<>(book);
		ResponseEntity<Book> response = restTemplate.exchange(apiUrl + "/" + book.getId(), HttpMethod.PUT,
				requestUpdate, Book.class);
		return response;
	}

	public void delete(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(apiUrl + "/" + id);
	}
}
