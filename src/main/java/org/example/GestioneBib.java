package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class GestioneBib {

    public static void main(String[] args) {
        GestioneArchivio gestioneBibl = new GestioneArchivio();
        Scanner sc = new Scanner(System.in);


        boolean continua = true;
        while (continua) {
            visualizzazioneMenuIniziale();
            String risposta = sc.nextLine();
            int resp = 0;
            try {
                resp = Integer.parseInt(risposta);
            } catch (Exception e) {
                System.out.println("DEVI INSERIRE UN NUMERO, CA**O!");
                continue;
            }
            switch (resp) {
                case 1: {
                    System.out.println("Pigia '1' per gli elementi di tipo Libro o '2' per elementi di tipo Rivista");
                    int resp2 = Integer.parseInt(sc.nextLine());
                    switch (resp2) {
                        case 1: {
                            System.out.println("Cosa vorresti fare? Pigia 1 per aggiungere un Libro o '2' per cercare un Libro");
                            int resp3 = Integer.parseInt(sc.nextLine());
                            switch (resp3) {
                                case 1: {
                                    gestioneBibl.aggiungiLibro(sc, new Libri());
                                    break;
                                }
                                case 2: {
                                    gestioneBibl.ricercaXISBN(sc);
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Cosa vorresti fare? Pigia '1' per aggiungere una nuova Rivista o '2' per cercare una Rivista");
                            int resp4 = Integer.parseInt(sc.nextLine());
                            switch (resp4) {
                                case 1: {
                                    gestioneBibl.aggiungiRivista(sc, new Riviste());
                                    break;

                                }
                                case 2: {
                                    gestioneBibl.ricercaXISBN(sc);
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Immetti qui sotto il codice del Libro/Rivista che vorresti eliminare !");
                    gestioneBibl.rimuoviTramiteISBN(sc);
                    break;
                }
                case 3: {
                    System.out.println("Inserisci qui l'anno di pubblicazione degli articoli che vuoi osservare:");
                    gestioneBibl.ricercaPerAnnoPubblicazione(sc);
                    break;
                }
                case 4: {
                    System.out.println("Inserisci il nome dell'Autore:");
                    gestioneBibl.ricercaPerNomeAutore(sc);
                    break;
                }
                case 5: {
                    gestioneBibl.modificaElemTramiteISBN(sc);
                    break;
                }
                case 6: {
                    gestioneBibl.statsArchivio(sc);

                }
                case 7: {
                    System.out.println("Che tu possa passare una buonissima giornata :)");
                    continua = false;
                    sc.close();
                    break;
                }
                default: {
                    System.out.println("Ma che cosa fai! Sei stupido? Devi mettere uno di quei numeri.");
                }
            }
        }
        System.out.println("Roba in Archivio: ");
        System.out.println(gestioneBibl);
    }

    private static void visualizzazioneMenuIniziale() {
        System.out.println("Cosa vorresti fare?");
        System.out.println("Inserisci '1' per aggiungere un elemento libro o rivista");
        System.out.println("Inserisci '2' per rimuovere un elemento tramite codice ISBN");
        System.out.println("Inserisci '3' per visualizzare tutti gli articoli in archivio per un determinato anno di pubblicazione");
        System.out.println("Inserisci '4' per visualizzare tutti gli articoli in archivio per un determinato Autore");
        System.out.println("Inserisci '5' per modificare un elemento cercandolo tramite ISBN");
        System.out.println("Inserisci '6' per visualizzare le Stats dell'Archivio!");
        System.out.println("Inserisci '7' per uscire.");
    }
}