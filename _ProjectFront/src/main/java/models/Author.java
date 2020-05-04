package models;

import java.util.Set;


public class Author {


	private int id;
	private String name;
	
	private Set<Book> books; 
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	Adresse adresse;

	public int getId() {
		return id;
	}

	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Author() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
