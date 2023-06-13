package org.lessons.java.events;

import java.time.LocalDate;

public class Evento {
    //ATTRIBUTI
    private String titolo;
    private LocalDate data;
    private int postiTot;
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
}
