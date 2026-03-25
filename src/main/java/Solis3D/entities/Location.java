package Solis3D.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String citta;
    @OneToMany(mappedBy = "location")
    private List<Evento> listaEventi = new ArrayList<>();

    public Location(){}

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    public void setListaEventi(List<Evento> listaEventi) {
        this.listaEventi = listaEventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
