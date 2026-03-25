package Solis3D.dao;

import Solis3D.entities.Partecipazione;
import Solis3D.exceptions.NoMatchException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione nuovaPartecipazione) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(nuovaPartecipazione);

        transaction.commit();

        System.out.println("Partecipazione salvata!");
    }

    public Partecipazione getById(UUID id) {
        Partecipazione trovata = this.entityManager.find(Partecipazione.class, id);
        if (trovata == null) throw new NoMatchException(id);
        return trovata;
    }

    public void delete(UUID id) {
        Partecipazione trovata = this.getById(id);

        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.remove(trovata);

        transaction.commit();

        System.out.println("Partecipazione eliminata!");
    }
}