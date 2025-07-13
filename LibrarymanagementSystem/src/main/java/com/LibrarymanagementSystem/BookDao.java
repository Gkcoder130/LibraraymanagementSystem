package com.LibrarymanagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class BookDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");

    public void addBook(Book b) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(b);
            tx.commit();
        } finally {
            em.close();
        }
    }

    public List<Book> getAllBooks() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("Select b from Book b", Book.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void updateBook(Book b) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(b);
            tx.commit();
        } finally {
            em.close();
        }
    }

    public void deleteBook(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Book b = em.find(Book.class, id);
            if (b != null) {
                em.remove(b);
            }
            tx.commit();
        } finally {
            em.close();
        }
    }
}