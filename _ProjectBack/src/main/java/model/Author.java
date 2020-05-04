package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			mappedBy = "author")
	@JsonBackReference
	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Embedded
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
