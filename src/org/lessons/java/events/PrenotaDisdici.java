package org.lessons.java.events;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

public class PrenotaDisdici {
    public static void main(String[] args) {
        Scanner utente = new Scanner(System.in);

        //*****************************EVENTO*************************************
        boolean errore;
        Evento evento = null;

        //ciclo per continuare a inserire dati evento finché non sono tutti corretti
        do{
            errore = false;
            //gestisco possibili eccezioni al momento della creazione dell' evento
            try{
                System.out.println("Inserisci titolo dell' evento");
                String titolo = utente.nextLine();

                System.out.println("Inserisci data dell' evento (yy-MM-dd)");
                LocalDate data = LocalDate.parse(utente.nextLine());

                System.out.println("Inserisci il numero totale di posti dell' evento");
                int postiTot = utente.nextInt();
                utente.nextLine();

                evento = new Evento(titolo, data, postiTot);
            } catch (RuntimeException e){
                System.out.println("Errore: " + e.getMessage());
                errore = true;
            }
        }while (errore);

        boolean esci = false;
        boolean esci2 = false;

        //ciclo per prenotare
        do{
            System.out.println("Vuoi effettuare una o più prenotazioni? (s/n)");
            String risposta = utente.nextLine().toLowerCase();
            switch (risposta){
                case "s":
                    System.out.println("Quante prenotazioni vuoi effettuare?");
                    int prenotazione = utente.nextInt();
                    utente.nextLine();

                    //gestisco possibili eccezioni legate al metodo prenota()
                    try {
                        for (int i = 0; i < prenotazione; i++) {
                            evento.prenota();
                        }
                    } catch (RuntimeException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }

                    System.out.println("I posti prenotati totali sono: " + evento.getPostiPrenotati());
                    System.out.println("I posti disponibili sono: " + (evento.getPostiTot() - evento.getPostiPrenotati()));
                    break;
                case "n":
                    System.out.println("Arrivederci!");
                    esci = true;
                    break;
                default:
                    System.out.println("Devi inserire una risposta che sia 's' o 'n'");
                    break;
            }
        }while(!esci);

        //ciclo per disdire
        do{
            System.out.println("Vuoi disdire una o più prenotazioni? (s/n)");
            String risposta = utente.nextLine().toLowerCase();
            switch (risposta){
                case "s":
                    System.out.println("Quante prenotazioni vuoi disdire?");
                    int disdetta = utente.nextInt();
                    utente.nextLine();

                    //gestisco possibili eccezioni legate al metodo disdici()
                    try {
                        for (int i = 0; i < disdetta; i++) {
                            evento.disdici();
                        }
                    } catch (RuntimeException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }

                    System.out.println("I posti prenotati totali sono: " + evento.getPostiPrenotati());
                    System.out.println("I posti disponibili sono: " + (evento.getPostiTot() - evento.getPostiPrenotati()));
                    break;
                case "n":
                    System.out.println("Arrivederci!");
                    esci2 = true;
                    break;
                default:
                    System.out.println("Devi inserire una risposta che sia 's' o 'n'");
                    break;
            }
        }while(!esci2);

        System.out.println(evento.toString());

        //*************************************CONCERTO***************************************+
        Concerto concerto = new Concerto("Shake The Snow Globe Tour", LocalDate.of(2023, 8, 21), 350, LocalTime.of(21, 30), "32.90");
        System.out.println(concerto.toString());


        //************************************PROGRAMMA EVENTI**********************************
//        ProgrammaEventi programma = new ProgrammaEventi("Summer Tour", List<Evento> eventi);
    }
}
