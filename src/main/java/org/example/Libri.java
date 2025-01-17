package org.example;

import java.time.Year;

public class Libri extends Archivio {
    private String autore;
    private String genere;
    public Libri(long codISBN, String titolo, Year annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;

    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro {" + super.toString() +
                "autore='" + autore + "'" +
                ", genere='" + genere + "'" +
                "}";
    }

}
