
package controllers;

import java.util.Arrays;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.Book;

@Controller
@RequestMapping("/books")
public class BookActions {

	@Autowired
	RestTemplate restTemplate;
	private static final String URL_API_BOOK = "http://localhost:8080/_ProjectBack/api/books";

	@RequestMapping("/v2/{id}")
	public String getOneV2(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
		ResponseEntity<Book> response = restTemplate.getForEntity(URL_API_BOOK + "/" + id, Book.class);
		Book b = response.getBody();
		ra.addFlashAttribute("book", b);
		System.out.println("Fin Front");
		return "redirect:/books";
	}

	@RequestMapping("")
	public String getAll(Model model, @ModelAttribute("book") Book b) {
		System.out.println("Redirect");
		ResponseEntity<Book[]> response = restTemplate.getForEntity(URL_API_BOOK, Book[].class);
		Book[] resuts = response.getBody();
		if (b != null)
			model.addAttribute("book", b);
		else
			model.addAttribute("book", new Book(0, ""));
		model.addAttribute("books", Arrays.asList(resuts));
		System.out.println("Fin Front");
		return "home";
	}
	
	@RequestMapping(value = "/crud", params = "update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book b, Model model, RedirectAttributes ra) {
		System.out.println("Clik pour Update Book: " + b);
		restTemplate.put(URL_API_BOOK + "/update", b);
		ra.addFlashAttribute("book", b);
		return "redirect:/books";
	}

	@RequestMapping(value = "/crud", params = "add", method = RequestMethod.POST)
	public String addBook(@Valid Book b, BindingResult results, RedirectAttributes ra) {
		restTemplate.postForEntity(URL_API_BOOK+"/add", b, HttpStatus.class );
		ra.addFlashAttribute("book", b);
		return "redirect:/books";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		restTemplate.delete(URL_API_BOOK+"/delete/"+id);
		return "redirect:/books";
	}

}
