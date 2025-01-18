package org.example;

import java.time.Year;

public class Riviste extends ElemBib {
    private Periodicita periodicita;


    public Riviste() {
        super();
        this.periodicita = null;
    }

    public Riviste(long codISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
       return "Rivista {" +super.toString() +
                "periodicita=" + periodicita +
                "}";
    }
}
