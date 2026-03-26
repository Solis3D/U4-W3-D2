package Solis3D.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento{

    @ManyToMany
    @JoinTable(
            name = "gare_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id")
    )
    private Set<Persona> atleti = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", descrizione='" + getDescrizione() + '\'' +
                ", tipoEvento=" + getTipoEvento() +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", numeroAtleti=" + atleti.size() +
                ", vincitore=" + (vincitore != null ? vincitore.getNome() + " " + vincitore.getCognome() : null) +
                '}';
    }

}
