package com.example.BitBi.service.abstruction;


import com.example.BitBi.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    // Metodo per ottenere tutti i libri
    List<Book> getAllBooks();

    // Metodo per trovare un libro per ID
    Optional<Book> findBookById(long id);

    // Metodo per creare o aggiornare un libro
    Book createBook(Book book);

    void updateBook(Book book);

    // Metodo per eliminare un libro per ID
    void deleteBookById(long id);
}
