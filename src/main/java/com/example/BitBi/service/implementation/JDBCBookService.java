package com.example.BitBi.service.implementation;

import com.example.BitBi.dto.BookDto;
import com.example.BitBi.entities.Book;
import com.example.BitBi.repository.abstruction.BookRepository;
import com.example.BitBi.service.abstruction.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Profile("jdbc")
@Qualifier("JDBC")
public class JDBCBookService implements BookService {

    private final ModelMapper mapper;
    private final BookRepository repository;

   /* @Autowired
    public JDBCBookService(BookRepository repository) {
        this.repository = repository;
        System.out.println("Il repository è: " + this.repository.getClass().getName());
    }*/

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = repository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books){
            BookDto bookDto = mapper.map(book , BookDto.class);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public BookDto findBookById(long id) {
        Optional<Book> bookOptional = repository.findById(id);
        if(bookOptional.isEmpty()){
            return null;
        }
        Book book = bookOptional.get();
        BookDto resultBook = mapper.map(book , BookDto.class);
        return resultBook;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return null;
    }

    @Override
    public void deleteBookById(long id) {
        repository.deleteById(id);
    }
}
