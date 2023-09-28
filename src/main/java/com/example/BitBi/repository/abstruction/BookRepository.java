package com.example.BitBi.repository.abstruction;

import com.example.BitBi.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    // Metodo per ottenere una lista di tutti i libri
    List<Book> findAll();

    // Metodo per trovare un libro per ID
    Optional<Book> findById(Long id);

    Optional<Book> findById(long id);

    // Metodo per salvare un libro
    Book save(Book book);

    // Metodo per eliminare un libro per ID
    void deleteById(Long id);
}