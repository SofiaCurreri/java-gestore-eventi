package org.lessons.java.events;

import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    //COSTRUTTORE
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    //METODI
    public void aggiungiEvento(List<Evento> evento){
        eventi.add((Evento) evento);
    }

//    public void eventiFiltratiPerData(LocalDate data){
//        List<Evento> eventiPerData = new ArrayList<>();
//        foreach (Evento e : eventi) {
//            eventiPerData.add(e);
//        }
//        return eventiPerData;
//    }

    public String getTitolo(){
        return this.titolo;
    }
    public int numEventi(){
        return eventi.size();
    }

    public void svuotaLista(){
        eventi.clear();
    }

    public void programma(){
        for (Evento evento : eventi) {
            System.out.println("\n" + evento.getData() + "-" + evento.getTitolo());
        }
    }
}
