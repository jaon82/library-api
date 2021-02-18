package dev.jaon.library.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jaon.library.api.model.Book;
import dev.jaon.library.api.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BooksService booksService;

	@GetMapping("")
	public Book[] index() {
		return booksService.findAll();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable(value = "id") Long id) {
		return booksService.findOne(id);
	}

	@PostMapping()
	public Book createBook(@RequestBody Book book) {
		return booksService.create(book);
	}

	@PutMapping()
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return booksService.update(book);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") Long id) {
		booksService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}