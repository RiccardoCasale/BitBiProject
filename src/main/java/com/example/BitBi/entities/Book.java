package com.example.BitBi.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDate ddp;
    private boolean hide;
    private Date dataDiCreazione;
    private Date ultimaModifica;

}
