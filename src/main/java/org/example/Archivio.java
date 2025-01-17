package org.example;

import java.time.Year;

public class Archivio {
    private long codISBN;
    private String titolo;
    private Year annoPubblicazione;
    private int numeroPagine;

    public Archivio(long codISBN, String titolo, Year annoPubblicazione, int numeroPagine) {
        this.codISBN = codISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(long codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Year getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Year annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return  "ID=" + codISBN +
                ", titolo='" + titolo + "'" +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine + ", "
                ;
    }
}
