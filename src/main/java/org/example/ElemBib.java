package org.example;

import java.time.Year;

public class ElemBib {
    private long codISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public ElemBib() {
        this.codISBN= 0;
        this.titolo= "";
        this.annoPubblicazione= 0;
        this.numeroPagine = 0;
    }

    public ElemBib(long codISBN, String titolo, int annoPubblicazione, int numeroPagine) {
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

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
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
