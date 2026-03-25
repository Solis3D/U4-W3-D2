package Solis3D.dao;

import Solis3D.entities.Evento;
import Solis3D.exceptions.NoMatchException;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save (Evento nuovoEvento){
        //Creo nuova transazione in primis con l'entity manager
        EntityTransaction transaction = this.entityManager.getTransaction();

        //faccio cominciare la transazione
        transaction.begin();

        // aggiungo il nuovo evento al persist, in modo che venga osservato dall'entity manager
        entityManager.persist(nuovoEvento);

        //infine faccio il commit in modo che venga inviato al DB e venga aggiunto alla tabella
        transaction.commit();

        System.out.println("Evento " + nuovoEvento.getTitolo() + " salvato!");
    }

    public Evento getById(UUID id){
        Evento trovato = entityManager.find(Evento.class, id);
        if (trovato == null) throw new NoMatchException(id);
        return trovato;
    }

    public void delete(UUID id) {
        Evento trovato = this.getById(id);

        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(trovato);

        transaction.commit();

        System.out.println("Evento" + trovato.getTitolo() + " eliminato!");
    }
}
