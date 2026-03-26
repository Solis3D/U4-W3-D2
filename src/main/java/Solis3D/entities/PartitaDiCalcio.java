package Solis3D.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento{

    @Column(name = "squadra_di_casa", nullable = false)
    private String squadraDiCasa;

    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "numero_goal_casa", nullable = false)
    private int numeroGoalCasa;

    @Column(name = "numero_goal_ospite", nullable = false)
    private int numeroGoalOspite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDicasa, String squadraOspite, String squadraVincente, int numeroGoalCasa, int numeroGoalOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDicasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGoalCasa = numeroGoalCasa;
        this.numeroGoalOspite = numeroGoalOspite;
    }

    public String getSquadraDicasa() {
        return squadraDiCasa;
    }

    public void setSquadraDicasa(String squadraDicasa) {
        this.squadraDiCasa = squadraDicasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGoalCasa() {
        return numeroGoalCasa;
    }

    public void setNumeroGoalCasa(int numeroGoalCasa) {
        this.numeroGoalCasa = numeroGoalCasa;
    }

    public int getNumeroGoalOspite() {
        return numeroGoalOspite;
    }

    public void setNumeroGoalOspite(int numeroGoalOspite) {
        this.numeroGoalOspite = numeroGoalOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", descrizione='" + getDescrizione() + '\'' +
                ", tipoEvento=" + getTipoEvento() +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGoalCasa +
                ", numeroGolSquadraOspite=" + numeroGoalOspite +
                '}';
    }
}
