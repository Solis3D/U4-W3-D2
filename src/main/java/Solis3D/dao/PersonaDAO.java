package Solis3D.dao;

import Solis3D.entities.Persona;
import Solis3D.exceptions.NoMatchException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona nuovaPersona){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(nuovaPersona);
        transaction.commit();

        System.out.println(nuovaPersona.getNome() + " " + nuovaPersona.getCognome() + " salvato!");
    }

    public Persona getById (UUID id) {
        Persona trovata = this.em.find(Persona.class, id);
        if (trovata == null) throw new NoMatchException(id);
        return trovata;
    }

    public void delete(UUID id) {
        Persona trovata = this.getById(id);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(trovata);
        transaction.commit();

        System.out.println(trovata.getNome() + " " + trovata.getCognome() + " eliminata!");
    }
}
