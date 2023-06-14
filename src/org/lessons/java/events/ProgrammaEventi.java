package org.lessons.java.events;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    //COSTRUTTORE
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    //METODI
    public void aggiungiEvento(Evento evento){
        eventi.add(evento);
    }

    public List<Evento> eventiFiltratiPerData(LocalDate data){
        List<Evento> eventiPerData = new ArrayList<>();
        for (Evento e : eventi) {
            if(e.getData().isEqual(data)){
                eventiPerData.add(e);
            }
        }
        return eventiPerData;
    }

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
