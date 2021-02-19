package dev.jaon.library.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jaon.library.api.model.Author;
import dev.jaon.library.api.model.Book;
import dev.jaon.library.api.service.AuthorsService;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorsController {
	@Autowired
	private AuthorsService authorsService;

	@GetMapping
	public Author[] index() {
		return authorsService.findAll();
	}

	@GetMapping("/{id}")
	public Author getAuthor(@PathVariable(value = "id") Long id) {
		return authorsService.findOne(id);
	}

	@PostMapping
	public Author createAuthor(@RequestBody Author author) {
		return authorsService.create(author);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
		return authorsService.update(author);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAuthor(@PathVariable(value = "id") Long id) {
		authorsService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}/books")
	public Book[] getAuthorBooks(@PathVariable(value = "id") Long id) {
		return authorsService.getAuthorBooks(id);
	}

}
