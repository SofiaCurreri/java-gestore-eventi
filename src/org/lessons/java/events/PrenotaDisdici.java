package org.lessons.java.events;

import java.time.LocalDate;
import java.util.Scanner;

public class PrenotaDisdici {
    public static void main(String[] args) {
        Scanner utente = new Scanner(System.in);

        System.out.println("Inserisci titolo dell' evento");
        String titolo = utente.nextLine();

        System.out.println("Inserisci data dell' evento (yy/MM/dd)");
        LocalDate data = LocalDate.parse(utente.nextLine());

        System.out.println("Inserisci il numero totale di posti dell' evento");
        int postiTot = utente.nextInt();
        utente.nextLine();

        Evento evento = new Evento(titolo, data, postiTot);

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

                    for (int i = 0; i < prenotazione; i++) {
                        evento.prenota();
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

                    for (int i = 0; i < disdetta; i++) {
                        evento.disdici();
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
    }
}
