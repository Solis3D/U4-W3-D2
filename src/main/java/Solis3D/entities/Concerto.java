package Solis3D.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(name = "genere", nullable = false)
    private GenereConcerto genere;

    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

    public Concerto(){}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", descrizione='" + getDescrizione() + '\'' +
                ", tipoEvento=" + getTipoEvento() +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
