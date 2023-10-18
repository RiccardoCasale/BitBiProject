package com.example.BitBi.controller;

import com.example.BitBi.dto.BookDto;
import com.example.BitBi.entities.Book;
import com.example.BitBi.service.abstruction.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){this.bookService = bookService;}

    /**
     * Questo metodo è annotato con @GetMapping, il che significa che verrà eseguito
     * quando viene effettuata una richiesta HTTP GET a "/book". L'annotazione @GetMapping
     * è una parte fondamentale del routing delle richieste HTTP in Spring.
     *
     * In questo specifico caso, quando un client effettua una richiesta GET a "/book",
     * questo metodo verrà chiamato per gestire la richiesta. Il metodo può contenere
     * la logica necessaria per recuperare e restituire i dati relativi ai libri, che
     * saranno poi restituiti al client in formato JSON.
     *
     * Il valore "/book" specificato nell'annotazione rappresenta l'endpoint URL a cui
     * questo metodo risponderà. Puoi personalizzare questo valore in base alle tue
     * esigenze, ad esempio, per gestire richieste a URL diversi.
     *
     * @return Un oggetto ResponseEntity che contiene una lista di oggetti BookDto.
     *         Questi dati saranno serializzati in formato JSON e inviati al client.
     */
    @GetMapping(value = "/book")
    public ResponseEntity<Iterable<BookDto>> getAllBooks(){

        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping(value = "/book/{id}")
    public ResponseEntity<BookDto> findByIdDto(@PathVariable long id){
        BookDto bookDto = bookService.findBookById(id);
        if(bookDto == null){
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookDto , HttpStatus.OK);
    }

    @PostMapping(value = "/book")
    public ResponseEntity<BookDto> createBookDto(@RequestBody BookDto bookDto){
        BookDto result = bookService.createBook(bookDto);
        return new ResponseEntity<>(result , HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
