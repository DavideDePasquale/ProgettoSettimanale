package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestioneArchivio {
    private List<ElemBib> archivio;

    public GestioneArchivio() {
        archivio = new ArrayList<>();
    }

    private boolean checkISBN(Long isbm) {
        boolean isValid = true;
        for (ElemBib a : archivio) {
            if (a.getCodISBN() == isbm) {
                System.out.println("ERRORE! Non puoi creare qualcosa con lo stesso ISBN!");
                isValid = false;
            }
            return isValid;
        }
        return isValid;
    }

    public List<ElemBib> getArchivio() {
        return archivio;
    }

    @Override
    public String toString() {
        String resp = "";
        for (ElemBib arch : archivio) {
            resp = resp.concat(arch.toString()).concat("\n");
        }
        return resp;
    }
    public void aggiungiLibro(Scanner sc,ElemBib elemento) {
        System.out.println("Inserisci il codice ISBN del libro che vuoi aggiungere!");
        long codISBN = Long.parseLong(sc.nextLine()); // Leggi la risposta dell'utente

        while (!checkISBN(codISBN)) {
            System.out.println("INSERISCI DI NUOVO IL COD ISBN! NON ERA VALIDO");
            codISBN = Long.parseLong(sc.nextLine()); // Leggi la risposta dell'utente
        }
        System.out.println("Perfetto, ISBN valido");
        elemento.setCodISBN(codISBN);
        System.out.println("Perfetto! Adesso inserisci il titolo del libro");
        String titolo = sc.nextLine(); //RISPOSTA DI TIPO STRINGA
        //3) DEVO DOMANDARE L'ANNO DI PUBBLICAZIONE IN FORMATO YEAR
        System.out.println("Bravo. Adesso inserisci l'anno di pubblicazione del libro");
        int annoPubblicazione = Integer.parseInt(sc.nextLine());//RISPOSTA ANCH'ESSO IN FORMATO YEAR GRAZIE ALLA CONVERSIONE DELLA STRINGA DELLO SCANNER
        //4) CHIEDO DI INSERIRE LE PAGINE TOTALI IN FORMATO INT
        System.out.println("Ci sei quasi! Adesso inserisci il numero di pagine totale");
        int numeroPagine = Integer.parseInt(sc.nextLine()); //CONVERSIONE DELLA RISPOSTA TRAMITE SCANNER IN INT
        //FACCIO LA DOMANDA PER RIEMPIRE I PARAMETRI DI "LIBRI"
        //1) FACCIO LA DOMANDA PER AGGIUNGERE L'ISBN TRAMITE SCANNER
        //5) CHIEDO DI INSERIRE L'AUTORE DEL LIBRO
        System.out.println("Inserisci l'autore del libro");
        String autore = sc.nextLine(); // GIA IN FORMATO STRINGA, NO CONVERSIONE
        //6) CHIEDO DI INSERIRE IL GENERE DEL LIBRO (GIà STRINGA)
        System.out.println("Hai praticamente finito! Inserisci per ultimo il genere del libro");
        String genere = sc.nextLine(); //GENERE FORMATO STRINGA
        //ISTANZIO IL NUOVO LIBRO CON I PARAMETRI IMMESSI PRIMA TRAMITE SCANNER
       // Libri libro = new Libri(codISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
        Libri libro = new Libri(codISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
        archivio.add(libro);//AGGIUNGO IL LIBRO ALLA LISTA DEI LIBRI
        System.out.println("Libro aggiunto all'archivio!"); //MESSAGGIO CARINO GIUSTO PER
    }
    public void aggiungiRivista(Scanner sc,ElemBib elemento){
        System.out.println("Inserisci il codice ISBN del libro che vuoi aggiungere!");
        long codISBN = Long.parseLong(sc.nextLine()); // Leggi la risposta dell'utente

        while (!checkISBN(codISBN)) {
            System.out.println("INSERISCI DI NUOVO IL COD ISBN! NON ERA VALIDO");
            codISBN = Long.parseLong(sc.nextLine()); // Leggi la risposta dell'utente
        }
        System.out.println("Perfetto, ISBN valido");
        elemento.setCodISBN(codISBN);


        System.out.println("Perfetto! Adesso inserisci il titolo del libro");
        String titolo = sc.nextLine(); //RISPOSTA DI TIPO STRINGA
        //3) DEVO DOMANDARE L'ANNO DI PUBBLICAZIONE IN FORMATO YEAR
        System.out.println("Bravo. Adesso inserisci l'anno di pubblicazione del libro");
        int annoPubblicazione = Integer.parseInt(sc.nextLine());//RISPOSTA ANCH'ESSO IN FORMATO YEAR GRAZIE ALLA CONVERSIONE DELLA STRINGA DELLO SCANNER
        //4) CHIEDO DI INSERIRE LE PAGINE TOTALI IN FORMATO INT
        System.out.println("Ci sei quasi! Adesso inserisci il numero di pagine totale");
        int numeroPagine = Integer.parseInt(sc.nextLine()); //CONVERSIONE DELLA RISPOSTA TRAMITE SCANNER IN INT
        System.out.println("Inserisci il tipo di pubblicazione : 'SETTIMANALE', 'MENSILE' o 'SEMESTRALE'");
        Periodicita periodicita = Periodicita.valueOf(sc.nextLine().toUpperCase());
        Riviste rivista = new Riviste(codISBN,titolo,annoPubblicazione,numeroPagine,periodicita);
        archivio.add(rivista);
        System.out.println("Rivista aggiunta con successo!");
    }
    public void ricercaXISBN(Scanner sc) {
         boolean loop = true;
        while (loop){
        System.out.println("Inserisci un codice ISBN per cercare il libro");
        long codISBN = Long.parseLong(sc.nextLine());
        boolean codiceTrovato = false;
        for (ElemBib el : archivio){
            if (el.getCodISBN() == codISBN){
                System.out.println("Ecco il libro da te cercato : " + el);
                codiceTrovato = true;
                break;
            }
        } if (!codiceTrovato){
            System.out.println("Nessun articolo trovato con il codice : " + codISBN);
        }
            System.out.println("Vuoi cercare con un altro codice? si/no");
        String response = sc.nextLine().trim().toLowerCase();
        if (response.equals("no")){
            loop = false;
        }
        }
        System.out.println("Ricerca finita!");
    }
    public void ricercaPerAnnoPubblicazione(Scanner sc){
        int annoPubb = sc.nextInt();
        sc.nextLine();
        List<ElemBib> elementiTrovati = archivio.stream().filter(el -> el.getAnnoPubblicazione() == annoPubb).toList();
        if(elementiTrovati.isEmpty()){
            System.out.println("Non è stato trovato nessun elemento pubblicato l'anno : " + annoPubb);
        } else {
            System.out.println("Ecco cosa è stato pubblicato nell'anno " + annoPubb + " :");
            for (ElemBib elemento : elementiTrovati){
                System.out.println(elemento);
            }
        }
    }
    public void ricercaPerNomeAutore(Scanner sc){
        String ricercaAutore = sc.nextLine();
        List<Libri> listaLibri = archivio.stream().filter(elem -> elem instanceof Libri && ((Libri) elem).getAutore()
                .equalsIgnoreCase(ricercaAutore)).map(elem -> (Libri) elem).toList();
        if(listaLibri.isEmpty()){
            System.out.println("Non ci sono Libri dell'autore " + ricercaAutore);
        } else {
            System.out.println("L'autore " + ricercaAutore + " ha scritto i seguenti libri: ");
            for (Libri libro : listaLibri ){
                System.out.println(libro);
            }
        }
    }
    public void rimuoviTramiteISBN(Scanner sc) {
        boolean loop = true;
        while (loop){
            System.out.println("Inserisci un codice ISBN per cercare il libro");
            long codISBN = Long.parseLong(sc.nextLine());
            boolean codiceTrovato = false;
            for (ElemBib el : archivio){
                if (el.getCodISBN() == codISBN){
                    System.out.println("Ecco l'elemento da te eliminato : " + el);
                    codiceTrovato = true;
                    break;
                }
            } if (!codiceTrovato){
                System.out.println("Nessun articolo trovato con il codice : " + codISBN);
            }
            System.out.println("Vuoi eliminare un elemento con un altro codice? si/no");
            String response = sc.nextLine().trim().toLowerCase();
            if (response.equals("no")){
                loop = false;
            }

        }
        System.out.println("Arrivederci.");
    }

}
