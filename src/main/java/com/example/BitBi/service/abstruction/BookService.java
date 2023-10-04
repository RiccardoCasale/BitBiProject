package com.example.BitBi.service.abstruction;


import com.example.BitBi.dto.BookDto;
import com.example.BitBi.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    // Metodo per ottenere tutti i libri
    List<BookDto> getAllBooks();

    // Metodo per trovare un libro per ID
    BookDto findBookById(long id);

    // Metodo per creare o aggiornare un libro
    BookDto createBook(BookDto bookDto);

    BookDto updateBook(BookDto bookDto);

    // Metodo per eliminare un libro per ID
    void deleteBookById(long id);
}
