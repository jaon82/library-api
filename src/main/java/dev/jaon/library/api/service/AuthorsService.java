package dev.jaon.library.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.jaon.library.api.model.Author;

@Service
public class AuthorsService {
	private final String apiUrl = "https://bibliapp.herokuapp.com/api/authors";

	public Author[] findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Author[] authors = restTemplate.getForObject(apiUrl, Author[].class);
		return authors;
	}
}
