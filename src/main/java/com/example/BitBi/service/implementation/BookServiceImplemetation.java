package com.example.BitBi.service.implementation;

import com.example.BitBi.entities.Book;
import com.example.BitBi.repository.abstruction.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImplemetation {

    // Metodo per ottenere tutti gli book
    Iterable<Book> getAllBook();

    // Metodo per trovare uno book per ID
    default Optional<Book> findBookById(long id) {
        return null;
    }

    // Metodo per creare uno book
    default Book create(Book book) {

        return book;
    };

    void delete (long id);

    void update (Book s);
}
