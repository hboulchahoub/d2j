package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Book;
import service.IBookService;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
	@Autowired
	private IBookService service;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Book getOne(@PathVariable("id") int id) {
		Book b = service.searchById(id);
		return b;
	}
	
	@GetMapping(path = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Book> getAll() {
		return service.getAll();
	}

	@PutMapping(path = "/update")
	public void update(@RequestBody Book b) {
		service.update(b);
	}
	
	@PostMapping(path = "/add")
	public void add(@RequestBody Book b) {
		service.add(b);
	}

	@GetMapping(path = "/{id}")
	public Book searchById(@PathVariable("id") int id) {
		System.out.println("Call for service....");
		return service.searchById(id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		System.out.println("Call for service....");
		 service.delete(id);
	}
}
