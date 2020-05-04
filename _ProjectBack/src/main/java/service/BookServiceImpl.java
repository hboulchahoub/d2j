package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IBookDao;
import model.Book;

@Service(value="bookServiceImpl")
@Transactional
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookDao dao;
	
	@Override
	public Book searchById(int id) {
		return dao.selectById(id);
	}

	
	@Override
	public void add(Book b) {
		 dao.add(b);
	}


	@Override
	public List<Book> getAll() {
		return dao.getAll();
	}


	@Override
	public void update(Book b) {
		dao.update(b);
	}


	@Override
	public void delete(int id) {
		dao.delete(id);
	}

}
