package org.example;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class GestioneBib
{
    public static List<Libri> listaLibri; //CREO UNA LISTA DI LIBRI
    public static List<Riviste> listaRiviste; // CREO UNA LISTA DI RIVISTE
    public static Scanner sc;

    public static void main( String[] args ) {
        GestioneBib.avviaProg();
        }
       public static void avviaProg(){
           listaLibri = new ArrayList<>(); //LISTA VUOTA DI LIBRI
           listaRiviste = new ArrayList<>(); //LISTA VUOTA DI RIVISTE
           sc = new Scanner(System.in); //MI SERVE PER LEGGERE CIò CHE ANDRò(O ANDRAI) A IMMETTERE NEL TERMINALE
        boolean continua = true;
       while (continua){
           System.out.println("Cosa vorresti fare?");
           System.out.println("Inserisci '1' per aggiungere un libro!");
           System.out.println("Inserisci '2' per aggiungere una rivista!");
           System.out.println("Inserisci '3' per visualizzare tutti i libri in archivio");
           System.out.println("Inserisci '4' per visualizzare tutte le riviste in archivio");
           System.out.println("Inserisci '5' per uscire");
           String risposta = sc.nextLine();
           int resp = 0;
          try {
              resp = Integer.parseInt(risposta);
          } catch (Exception e) {
              System.out.println("DEVI INSERIRE UN NUMERO, CA**O!");
              continue;
          }
           switch (resp){
               case 1: {
                   aggiungiLibro();
                   break;
               } case 2: {
                   aggiungiRivista();
                   break;
               } case 3 : {
                   mostraTuttiILibri();
                   break;
               } case 4 : {
                   mostraTutteLeRiviste();
                   break;
               } case 5: {
                   continua = false;
                   System.out.println("Che tu possa passare una buonissima giornata :)");
                   break;
               } default:  {
                   System.out.println("Ma che cosa fai! Sei stupido? Devi mettere uno di quei numeri.");
               }
           }
       }
    }

    public static void aggiungiLibro(){
        //FACCIO LA DOMANDA PER RIEMPIRE I PARAMETRI DI "LIBRI"
        //1) FACCIO LA DOMANDA PER AGGIUNGERE L'ISBN TRAMITE SCANNER
        long codISBN = 0; //(LO INIZIALIZZO)
        boolean inputcodISBNvalido = false;

        while (!inputcodISBNvalido) {
            System.out.println("Inserisci il codice ISBN della rivista che vuoi aggiungere!");
            String codISBNnonValido = sc.nextLine(); // Leggi la risposta dell'utente

            try {
                // PASSAGGIO DELLA RISPOSTA STRINGA A , SE POSSIBILE, LONG.
                codISBN = Long.parseLong(codISBNnonValido);
                inputcodISBNvalido = true;  // SE EFFETTIVAMENTE VIENE CONVERTITO, SI SALVA DOME TIPO LONG
            } catch (NumberFormatException e) {
                // SE VIENE INSERITO UN VALORE NON VALIDO AL MOMENTO DELLA CONVERSIONE A LONG, STAMPO UN ERRORE E RIPRESENTO LA DOMANDA
                System.out.println("Errore: Devi inserire un numero valido (ad esempio, 1234567890)!");
            }
        }
        System.out.println("Perfetto! Adesso inserisci il titolo del libro");
        String titolo = sc.nextLine(); //RISPOSTA DI TIPO STRINGA
        //3) DEVO DOMANDARE L'ANNO DI PUBBLICAZIONE IN FORMATO YEAR
        System.out.println("Bravo. Adesso inserisci l'anno di pubblicazione del libro");
        Year annoPubblicazione = Year.parse(sc.nextLine()); //RISPOSTA ANCH'ESSO IN FORMATO YEAR GRAZIE ALLA CONVERSIONE DELLA STRINGA DELLO SCANNER
        //4) CHIEDO DI INSERIRE LE PAGINE TOTALI IN FORMATO INT
        System.out.println("Ci sei quasi! Adesso inserisci il numero di pagine totale");
        int numeroPagine = Integer.parseInt(sc.nextLine()); //CONVERSIONE DELLA RISPOSTA TRAMITE SCANNER IN INT
        //5) CHIEDO DI INSERIRE L'AUTORE DEL LIBRO
        System.out.println("Inserisci l'autore del libro");
        String autore = sc.nextLine(); // GIA IN FORMATO STRINGA, NO CONVERSIONE
        //6) CHIEDO DI INSERIRE IL GENERE DEL LIBRO (GIà STRINGA)
        System.out.println("Hai praticamente finito! Inserisci per ultimo il genere del libro");
        String genere = sc.nextLine(); //GENERE FORMATO STRINGA
        //ISTANZIO IL NUOVO LIBRO CON I PARAMETRI IMMESSI PRIMA TRAMITE SCANNER
        Libri libro = new Libri(codISBN,titolo,annoPubblicazione,numeroPagine,autore,genere);
        listaLibri.add(libro); //AGGIUNGO IL LIBRO ALLA LISTA DEI LIBRI
        System.out.println("Libro aggiunto all'archivio!"); //MESSAGGIO CARINO GIUSTO PER

    }
    public static void aggiungiRivista(){
        //FACCIO LA DOMANDA PER RIEMPIRE I PARAMETRI DI "RIVISTE"
        //1) FACCIO LA DOMANDA PER AGGIUNGERE L'ISBN TRAMITE SCANNER
        System.out.println("Inserisci il codice ISBN della rivista che vuoi aggiungere!");
        long codISBN = Long.parseLong(sc.nextLine());//RISPOSTA DI TIPO LONG PERCHè è UN PARAMETRO RICHIESTO IN RIVISTE ED è DI QUEL TIPO (CONVERTITA DA STRINGA A LONG)
        //2) DEVO CHIEDERE IL TITOLO IN FORMATO STRINGA
        System.out.println("Perfetto! Adesso inserisci il titolo della rivista");
        String titolo = sc.nextLine(); //RISPOSTA DI TIPO STRINGA
        //3) DEVO DOMANDARE L'ANNO DI PUBBLICAZIONE IN FORMATO YEAR
        System.out.println("Bravo. Adesso inserisci l'anno di pubblicazione della rivista");
        Year annoPubblicazione = Year.parse(sc.nextLine()); //RISPOSTA ANCH'ESSO IN FORMATO YEAR GRAZIE ALLA CONVERSIONE DELLA STRINGA DELLO SCANNER
        //4) CHIEDO DI INSERIRE LE PAGINE TOTALI IN FORMATO INT
        System.out.println("Ci sei quasi! Adesso inserisci il numero di pagine totale");
        int numeroPagine = Integer.parseInt(sc.nextLine()); //CONVERSIONE DELLA RISPOSTA TRAMITE SCANNER IN INT
        //5) DOMANDO LA PERIODICITA CHE è A SUA VOLTA UN ENUM IN RIVISTE
        System.out.println("Per ultimo, inserisci la periodicità di pubblicazione della rivista (SETTIMANALE, MENSILE o SEMETRALE)");
        String pubb = sc.nextLine().toUpperCase(); // SICCOME IN AUTOMATICO LA TASTIERA NON è IN FORMATO MAIUSCOLO, SE DOVESSI SCRIVERLO IN MINUSCOLO MI RESTITUISCE IN OGNI CASO LA PAROLA IN MAIUSCOLO COSI DA RIFLETTERSI CON LE OPZIONI DELL'ENUM
        Periodicita pubb1 = Periodicita.valueOf(pubb); //  CONTROLLO SE LA STRINGA PUBB CORRISPONDE A UNA DELLE OPZIONI DELL'ENUM
        Riviste rivista = new Riviste(codISBN,titolo,annoPubblicazione,numeroPagine,pubb1); //ISTANZIO LA NUOVA RIVISTA CON I PARAMETRI CREATI TRAMITE SCANNER
        listaRiviste.add(rivista); // AGGIUNGO LA RIVISTA NELLA LISTA DELLE RIVISTE
        System.out.println("Rivista aggiunta, bravo!!"); // GIUSTO PER


    }
    public static void mostraTuttiILibri(){
        // MI CREO IL METODO PER CAPIRE SE EFFETTIVAMENTE ESISTE UNA LISTA PIENA DI LIBRI
        if(listaLibri.isEmpty()){
            System.out.println("Non sono presenti libri nell'archivio");
            // SE è EMPTY(QUINDI TRUE) MI DA COME STAMPA SUL TERMINALE QUELLA QUI SOPRA
        } else {
            for(Libri libro : listaLibri){
                System.out.println(libro);
                //SE NON è EMPTY, QUINDI FALSE, MI DA I LIBRI DELLA LISTA
            }
        }

    }
    public static void mostraTutteLeRiviste(){
        // STESSA PROCEDURA DI QUELLA SOPRA, SOLO CHE QUI TRATTO LA LISTA DI RIVISTE.
        if(listaRiviste.isEmpty()){
            System.out.println("Non ci sono riviste nell'archivio");
        } else {
            for (Riviste rivista : listaRiviste){
                System.out.println(rivista);
            }
        }
    }
}
