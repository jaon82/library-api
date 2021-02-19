package dev.jaon.library.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jaon.library.api.model.Author;
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
}
