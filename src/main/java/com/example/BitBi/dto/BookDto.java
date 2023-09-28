package com.example.BitBi.dto;

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

}
