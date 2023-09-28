package com.example.BitBi.service.implementation;


import com.example.BitBi.entities.Book;
import com.example.BitBi.repository.abstruction.BookRepository;
import com.example.BitBi.service.abstruction.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("jdbc")
@Qualifier("JDBC")
public class JDBCBookService implements BookService {

    private final BookRepository repository;

    @Autowired
    public JDBCBookService(BookRepository repository) {
        this.repository = repository;
        System.out.println("Il repository è: " + this.repository.getClass().getName());
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findBookById(long id) {
        return repository.findById(id);
    }

    @Override
    public Book createOrUpdateBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteBookById(long id) {
        repository.deleteById(id);
    }
}
