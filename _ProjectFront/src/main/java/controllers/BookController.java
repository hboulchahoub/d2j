
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.Book;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	RestTemplate restTemplate;
	private static final String URL_API_BOOK = "http://localhost:8080/_ProjectBack/api/books";

	@RequestMapping
	public String home( Model model) {
		model.addAttribute("book", new Book(0, ""));
		return "home";
	}

	@RequestMapping("/{id}")
	public String getOne(@PathVariable("id") int id, Model model) {
		ResponseEntity<Book> response = restTemplate.getForEntity(URL_API_BOOK + "/" + id, Book.class);
		Book b = response.getBody();
		model.addAttribute("book", b);
		System.out.println("Fin Front");
		return "home";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(Book b, Model model) {
		restTemplate.postForEntity(URL_API_BOOK + "/add", b, HttpStatus.class);
		model.addAttribute("book", b);
		return "home";
	}
}