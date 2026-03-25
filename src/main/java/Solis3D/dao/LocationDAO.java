package Solis3D.dao;

import Solis3D.entities.Location;
import Solis3D.exceptions.NoMatchException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Location nuovaLocation){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(nuovaLocation);
        transaction.commit();

        System.out.println("Location " + nuovaLocation.getNome() + " salvata!");
    }

    public Location getById(UUID id){
        Location trovata = this.em.find(Location.class, id);
        if (trovata == null) throw new NoMatchException(id);
        return trovata;
    }

    public void delete(UUID id){
        Location trovata = getById(id);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(trovata);
        transaction.commit();

        System.out.println("Location " + trovata.getNome() + " eliminata!");
    }
}
