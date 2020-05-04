package dao;

import java.util.List;

import model.Book;

public interface IBookDao {
	public void update(Book b);
	public void add(Book b);
	public Book selectById(int id);
	public List<Book> getAll();
	public void delete(int id);

	
}
