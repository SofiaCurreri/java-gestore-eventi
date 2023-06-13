package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    //ATTRIBUTI
    private String titolo;
    private LocalDate data;
    private final int postiTot;
    private int postiPrenotati;

    //COSTRUTTORE
    public Evento(String titolo, LocalDate data, int postiTot) {
        this.titolo = titolo;

        if(data.isBefore(LocalDate.now())){
            throw new RuntimeException("L' evento si è gia svolto, mi dispiace!");
        } else {
            this.data = data;
        }

        if(postiTot <= 0){
            throw new RuntimeException("Il numero totale di posti deve essere superiore a 0");
        } else {
            this.postiTot = postiTot;
        }

        this.postiPrenotati = 0;
    }

    //GETTER

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiTot() {
        return postiTot;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //SETTER

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        //faccio in modo che la data dell' evento possa solo essere posticipata
        if(data.isBefore(this.data)){
            throw new RuntimeException("Non puoi anticipare la data dell' evento, ma solo posticiparla!");
        } else {
            this.data = data;
        }
    }

    //METODI
    public void prenota(){
        if(getData().isBefore(LocalDate.now())) {
            throw new RuntimeException("L' evento si è gia svolto, impossibile procedere con la prenotazione");
        } else if ((getPostiTot() - getPostiPrenotati()) == 0) {
            throw new RuntimeException("Non ci sono più posti disponibili");
        } else {
            postiPrenotati = getPostiPrenotati() + 1;
        }
    }

    public void disdici(){
        if(getData().isBefore(LocalDate.now())) {
            throw new RuntimeException("L' evento si è gia svolto, impossibile procedere con la prenotazione");
        } else if (getPostiPrenotati() == 0) {
            throw new RuntimeException("Non ci sono ancora prenotazioni! Non c' è nulla da disdire");
        } else {
            postiPrenotati = getPostiPrenotati() - 1;
        }
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String dataFormattata = getData().format(formatter);
        return dataFormattata + "-" + getTitolo();
    }
}
