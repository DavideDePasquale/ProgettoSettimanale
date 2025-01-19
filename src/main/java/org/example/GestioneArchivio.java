package org.example;

import java.util.*;
public class GestioneArchivio {
    private List<ElemBib> archivio;

    public GestioneArchivio() {
        archivio = new ArrayList<>();
        elementiInizialiArchivio();
    }

    public void elementiInizialiArchivio(){
        archivio.add(new Libri(143, "Pinocchio", 2022, 25, "Lebonwski", "Horror"));
        archivio.add(new Libri(331, "La Bella Addormentata", 1995, 40, "Maccherone David", "Giallo"));
        archivio.add(new Libri(111, "La Bella e la Bestia", 1980, 10, "Ciannarella Oscar", "Horror"));
        archivio.add(new Libri(104, "Shrek",2000, 21, "Mastrangelo Daniele", "Commedy"));
        archivio.add(new Riviste(788, "Gazzetta del Buongiornissimo", 1999, 3, Periodicita.SEMESTRALE));
        archivio.add(new Riviste(611, "Paperino", 1959, 300, Periodicita.MENSILE));
        archivio.add(new Riviste(413, "Gazzetta dello Sport", 1919, 10, Periodicita.SETTIMANALE));

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
    public void modificaElemTramiteISBN (Scanner sc){
        System.out.println("Inserisci l'ISBN dell'elemento che vorresti modificare!");
        long codISBN = Long.parseLong(sc.nextLine());
       ElemBib elemento =  archivio.stream().filter(el -> el.getCodISBN() == codISBN).findFirst().orElse(null);
       if(elemento != null){
           System.out.println("Ecco l'elemento da te cercato : " + elemento);
           System.out.println("Cosa vorresti modificare?");
           System.out.println("1. Per modificare il titolo");
           System.out.println("2. Per modificare l'anno di pubblicazione");
           System.out.println("3. Per modificare il numero totale di pagine");
           if(elemento instanceof Libri){
               System.out.println("4. Per modificare l'autore");
               System.out.println("5. Per modificare il genere");
           } else if(elemento instanceof Riviste){
               System.out.println("4. Per modificare il tipo di pubblicazione della rivista");
           }
           int sceltaRisposta = Integer.parseInt(sc.nextLine());
           switch (sceltaRisposta){
               case 1: {
                   System.out.println("Inserisci il nuovo titolo : ");
                   String newTitle = sc.nextLine();
                   elemento.setTitolo(newTitle);
                   System.out.println("Titolo modificato! Congratulazioni");
                   break;
               } case 2: {
                   System.out.println("Inserisci il nuovo anno di pubblicazione");
                   int newYear = Integer.parseInt(sc.nextLine());
                   elemento.setAnnoPubblicazione(newYear);
                   System.out.println("Anno di pubblicazione modificato");
                   break;
               } case 3: {
                   System.out.println("Metti il nuovo numero di pagine");
                   int newNumberofPage = Integer.parseInt(sc.nextLine());
                   elemento.setNumeroPagine(newNumberofPage);
                   System.out.println("Numero di pagine modificato!");
                   break;
               } case 4 : {
                   if (elemento instanceof Libri){
                       System.out.println("Inserisci il nuovo nome dell'autore!");
                       String newAutore = sc.nextLine();
                       ((Libri) elemento).setAutore(newAutore);
                       System.out.println("Nome dell'Autore modificato!");

                   } else if (elemento instanceof Riviste) {
                       System.out.println("Modifica il tipo di pubblicazione della Rivista!");
                       String newTipoDiPubblicazione = sc.nextLine().toUpperCase();
                       Periodicita tipoDiPubblicazione = null;
                       switch (newTipoDiPubblicazione){
                           case "settimanale" : {
                               tipoDiPubblicazione = Periodicita.SETTIMANALE;
                               break;
                           } case "mensile" : {
                               tipoDiPubblicazione = Periodicita.MENSILE;
                               break;
                           } case "semestrale" : {
                               tipoDiPubblicazione = Periodicita.SEMESTRALE;
                               break;
                           } default: {
                               System.out.println("Tipo di pubblicazione inserito non valido! Le 3 opzioni disponibili sono : settimanale, mensile o semetrale");
                               return;
                           }
                       }
                       ((Riviste) elemento).setPeriodicita(tipoDiPubblicazione);
                       System.out.println("Tipo di pubblicazione modificato!!");
                   }
                   break;
               } case 5 : {
                   if(elemento instanceof Libri){
                       System.out.println("Inserisci il nuovo genere del Libro");
                       String newGenere = sc.nextLine();
                       ((Libri)elemento).setGenere(newGenere);
                       System.out.println("Genere modificato!");
                   }
                   break;
               } default: {
                   System.out.println("Il cod ISBN fornito ( " + codISBN + " ) non appartiene a nessun elemento");
               }
           }
       }


    }
    public void statsArchivio(){
        long numLibri = archivio.stream().filter(elem -> elem instanceof Libri).count();
        long numRiviste = archivio.stream().filter(elem ->elem instanceof Riviste).count();
        Optional<ElemBib> elementoMaxPage = archivio.stream().max(Comparator.comparingInt(ElemBib::getNumeroPagine));
        if (elementoMaxPage.isPresent()){
            System.out.println("L'elemento col maggior numero di pagine è : " + elementoMaxPage.get());
        } else {
            System.out.println("Nessun elemento in archivio! Devi prima crearti gli elementi!!!");
        }

        double mediaDellePage = archivio.stream().mapToInt(ElemBib::getNumeroPagine).average().orElse(0);
        System.out.println("Numero di Libri presenti in Archivio : " + numLibri);
        System.out.println("Numero di Riviste presenti in Archivio : " + numRiviste);
        System.out.println("Media pagine di tutti gli elementi in Archivio : " + mediaDellePage);

    }

}
