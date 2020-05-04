package service;

import java.util.List;

import model.Book;

public interface IBookService {
	void update(Book b);

	void add(Book b);

	public Book searchById(int id);

	public List<Book> getAll();

	public void delete(int id);
}
