package com.LibrarymanagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class BookDao {

    public void addBook(Book b) {
        EntityManager em = LibraryUtil.getEntityManager();
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
        EntityManager em = LibraryUtil.getEntityManager();
        try {
            return em.createQuery("Select b from Book b", Book.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void updateBook(Book b) {
        EntityManager em = LibraryUtil.getEntityManager();
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
        EntityManager em = LibraryUtil.getEntityManager();
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
