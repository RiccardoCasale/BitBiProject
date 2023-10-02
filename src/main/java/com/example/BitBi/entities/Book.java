package com.example.BitBi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

/*id, titolo, isbn, autore, npagine, categoria, genere, illustrazioni (boolean), autore illustrazioni (opzionale), commento
, lingua originale*/

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

    public Book(int id, String titolo, String isbn, String autore, String categoria, String genere, int nPagine, String autoreIllustrazioni, String lingua, java.sql.Date ddp, boolean hide, java.sql.Date dataDiCreazione, java.sql.Date ultimaModifica) {
    }


    //ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //TITOLO
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    //ISBN
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //AUTORE
    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }

    //CATEGORIA
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //GENERE
    public String getGenere() {
        return genere;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }

    //NUMEROPAGINE
    public int getnPagine() {
        return nPagine;
    }
    public void setnPagine(int nPagine) {
        this.nPagine = nPagine;
    }

    //AUTORE
    public String getAutoreIllustrazioni() {
        return autoreIllustrazioni;
    }
    public void setAutoreIllustrazioni(String autoreIllustrazioni) {
        this.autoreIllustrazioni = autoreIllustrazioni;
    }

    //LINGUA
    public String getLingua() {
        return lingua;
    }
    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    //HIDE
    public boolean isHide() {
        return hide;
    }
    public void setHide(boolean hide) {
        this.hide = hide;
    }

    //DATA DI CREAZIONE
    public Date getDataDiCreazione() {
        return dataDiCreazione;
    }
    public void setDataDiCreazione(Date dataDiCreazione) {
        this.dataDiCreazione = dataDiCreazione;
    }

    //ULTIMA MODIFICA
    public Date getUltimaModifica() {
        return ultimaModifica;
    }
    public void setUltimaModifica(Date ultimaModifica) {
        this.ultimaModifica = ultimaModifica;
    }

    //DATAPUBBLICAZIONE
    /*Serve per convertire date di java in un oggetto che ci permette di utilizzarlo su sql
     */
    public java.sql.Date getDdp() {
        return (java.sql.Date) ddp;
    }
    public void setDdp(Date ddp) {
        this.ddp = ddp;
    }

    public Book(int id, String titolo, String isbn, String autore, String categoria, String genere, int nPagine, String lingua, Date ddp, boolean hide, Date dataDiCreazione, Date ultimaModifica , String ... autoreIllustrazioni) {
        this.id = id;
        this.titolo = titolo;
        this.isbn = isbn;
        this.autore = autore;
        this.categoria = categoria;
        this.genere = genere;
        this.nPagine = nPagine;
        this.autoreIllustrazioni = Arrays.toString(autoreIllustrazioni);
        this.lingua = lingua;
        this.ddp = ddp;
        this.hide = hide;
        this.dataDiCreazione = dataDiCreazione;
        this.ultimaModifica = ultimaModifica;
    }

    @Override
    public String toString() {
        return "Book{" +
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
                '}';
    }
}
