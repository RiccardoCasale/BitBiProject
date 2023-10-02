package com.example.BitBi.dto;

import com.example.BitBi.entities.Book;

import java.time.LocalDate;

//DATA TRANSFER OBJECT. è un design pattern. Lo usiamo per trasferire dati tra i diversi componenti dell'applicazione
@Data
public class BookDto {

    private int id;
    private String titolo;
    private String autore;
    private String categoria;
    private String genere;
    private int nPagine;
    private String autoreIllustrazioni;
    private String lingua;


    public BookDto(int id, String titolo, String autore) {
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", categoria='" + categoria + '\'' +
                ", genere='" + genere + '\'' +
                ", nPagine=" + nPagine +
                ", autoreIllustrazioni='" + autoreIllustrazioni + '\'' +
                ", lingua='" + lingua + '\'' +
                '}';
    }

    public Book toBook() {
        Book book = new Book();
        book.setTitolo(this.fullName);
        book.setIsbn(""); // Imposta l'ISBN a vuoto o inizializzalo in base alle tue esigenze
        book.setAutore(""); // Imposta l'autore a vuoto o inizializzalo in base alle tue esigenze
        book.setCategoria(""); // Imposta la categoria a vuoto o inizializzala in base alle tue esigenze
        book.setGenere(""); // Imposta il genere a vuoto o inizializzalo in base alle tue esigenze
        book.setnPagine(0); // Imposta il numero di pagine a 0 o inizializzalo in base alle tue esigenze
        book.setAutoreIllustrazioni(""); // Imposta l'autore delle illustrazioni a vuoto o inizializzalo in base alle tue esigenze
        book.setLingua(""); // Imposta la lingua a vuoto o inizializzala in base alle tue esigenze
        book.setDdp(java.sql.Date.valueOf(LocalDate.of(1000, 1, 1))); // Imposta la data di pubblicazione a una data predefinita o inizializzala in base alle tue esigenze
        book.setHide(false); // Imposta il flag "hide" a false o inizializzalo in base alle tue esigenze
        book.setDataDiCreazione(new java.sql.Date(System.currentTimeMillis())); // Imposta la data di creazione a quella corrente o inizializzala in base alle tue esigenze
        book.setUltimaModifica(new java.sql.Date(System.currentTimeMillis())); // Imposta la data di ultima modifica a quella corrente o inizializzala in base alle tue esigenze
        return book;
    }
}
