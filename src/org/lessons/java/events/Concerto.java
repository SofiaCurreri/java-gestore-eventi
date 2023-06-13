package org.lessons.java.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    //ATTRIBUTI
    private LocalTime ora;
    private BigDecimal prezzo;

    //COSTRUTTORE
    public Concerto(String titolo, LocalDate data, int postiTot, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, postiTot);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    //GETTER
    public LocalTime getOra() {
        return ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    //SETTER
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    //METODI
    public String oraFormattata(LocalTime ora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("00:00");
        return getOra().format(formatter);
    }

    public String dataFormattata(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        return getData().format(formatter);
    }
}
