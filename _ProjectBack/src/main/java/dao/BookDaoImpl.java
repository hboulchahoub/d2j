package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Book;

@Repository
public class BookDaoImpl implements IBookDao {
	@PersistenceContext
	public EntityManager em;

	@Override
	public Book selectById(int id) {
		return em.find(Book.class, id);
	}

	@Transactional
	@Override
	public void add(Book b) {
		em.persist(b);
	}

	@Override
	public List<Book> getAll() {
		TypedQuery<Book> req = em.createQuery("SELECT b FROM Book b", Book.class);
		return req.getResultList();
	}
	@Override
	public void update(Book newB) {
		Book old = em.find(Book.class, newB.getId());
		old.setTitle(newB.getTitle());
		//em.flush();
	}

	@Override
	public void delete(int id) {
		Book old = em.find(Book.class, id);
		em.remove(old);
	}
}
