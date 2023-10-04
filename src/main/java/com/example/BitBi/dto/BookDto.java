package com.example.BitBi.dto;

import com.example.BitBi.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

// DATA TRANSFER OBJECT. È un design pattern. Lo usiamo per trasferire dati tra i diversi componenti dell'applicazione
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private int id;
    private String titolo;
    private String isbn;
    private String autore;
    private String categoria;
    private String genere;
    private int nPagine;
    private String autoreIllustrazioni;
    private String lingua;
    private LocalDate ddp;
    private boolean hide;
    private Date dataDiCreazione;
    private Date ultimaModifica;

    public BookDto(Book b) {
        this.id = b.getId();
        this.titolo = b.getTitolo();
        this.autore = b.getAutore();
        this.isbn = b.getIsbn();
        this.categoria = b.getCategoria();
        this.genere = b.getGenere();
        this.hide = b.isHide();
        this.lingua = b.getLingua();
        this.nPagine = b.getNPagine();
        this.autoreIllustrazioni = b.getAutoreIllustrazioni();
        this.ddp = b.getDdp();
        this.ultimaModifica = (Date) b.getUltimaModifica();
        this.dataDiCreazione = (Date) b.getDataDiCreazione();
    }


    //
    public Book toBook() {
        String[] tokens = titolo.split(" ");

        if (tokens.length >= 2) {
            String titoloLibro = tokens[0] + " " + tokens[1];
            return new Book(id, titoloLibro, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp, hide, dataDiCreazione, ultimaModifica);
        } else {
            // Se il campo 'titolo' non contiene abbastanza token, crea comunque un libro con il titolo presente
            return new Book(id, titolo, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp, hide, dataDiCreazione, ultimaModifica);
        }
    }
}
