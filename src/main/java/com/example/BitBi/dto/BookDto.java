package com.example.BitBi.dto;

import com.example.BitBi.entities.Book;
import java.sql.Date;

// DATA TRANSFER OBJECT. È un design pattern. Lo usiamo per trasferire dati tra i diversi componenti dell'applicazione
@Data
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
    private Date ddp;
    private boolean hide;
    private Date dataDiCreazione;
    private Date ultimaModifica;

    public BookDto(int id, String titolo, String autore, String isbn, String categoria, String genere, int nPagine, String autoreIllustrazioni, String lingua, Date ddp, boolean hide, Date dataDiCreazione, Date ultimaModifica) {
        this.id = id;
        this.titolo = titolo;
        this.isbn = isbn;
        this.autore = autore;
        this.categoria = categoria;
        this.genere = genere;
        this.nPagine = nPagine;
        this.autoreIllustrazioni = autoreIllustrazioni;
        this.lingua = lingua;
        this.ddp = ddp;
        this.hide = hide;
        this.dataDiCreazione = dataDiCreazione;
        this.ultimaModifica = ultimaModifica;
    }

    public BookDto(Book b) {
        this.id = b.getId();
        this.titolo = b.getTitolo();
        this.autore = b.getAutore();
        this.isbn = b.getIsbn();
        this.categoria = b.getCategoria();
        this.genere = b.getGenere();
        this.hide = b.isHide();
        this.lingua = b.getLingua();
        this.nPagine = b.getnPagine();
        this.autoreIllustrazioni = b.getAutoreIllustrazioni();
        this.ddp = b.getDdp();
        this.ultimaModifica = (Date) b.getUltimaModifica();
        this.dataDiCreazione = (Date) b.getDataDiCreazione();
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autore='" + autore + '\'' +
                ", categoria='" + categoria + '\'' +
                ", genere='" + genere + '\'' +
                ", nPagine=" + nPagine +
                ", autoreIllustrazioni='" + autoreIllustrazioni + '\'' +
                ", lingua='" + lingua + '\'' +
                ", ddp=" + ddp +
                ", hide=" + hide +
                ", dataDiCreazione=" + dataDiCreazione +
                ", ultimaModifica=" + ultimaModifica +
                '}';
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
