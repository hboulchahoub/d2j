package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//2- @ManyToOne

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book {
	@ManyToOne (cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="FK_AUTH",referencedColumnName="id")
	@JsonBackReference
	private Author author;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Test")
	private String title;

	//ici
//	@ManyToOne(cascade=CascadeType.MERGE)
//	@JoinColumn(name="FK_TEST")
//	private Author author;
	
//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}

	public Book(String title) {
		super();
		this.title = title;
	}



	public Book() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
