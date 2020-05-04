package models;

import controllers.TitleConstraint;

public class Book {
	
	int id;
	
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

	@TitleConstraint
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
