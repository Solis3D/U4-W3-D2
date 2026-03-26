package Solis3D;

import Solis3D.dao.EventoDAO;
import Solis3D.dao.LocationDAO;
import Solis3D.dao.PartecipazioneDAO;
import Solis3D.dao.PersonaDAO;
import Solis3D.entities.*;
import Solis3D.exceptions.NoMatchException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("U4-W3-D2pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);

        //LOCATION
        Location location1 = new Location("Stadio Diego Armando Maradona" , "Napoli");
        //locationDAO.save(location1);
        Location locationConcerto = new Location("Arena di Verona", "Verona");

        //EVENTO
        /*Evento evento1 = new Evento("Napoli - Juventus", LocalDate.parse("2026-03-25"), "Partita di Serie A", TipoEvento.PUBBLICO, 50000,location1);*/
        //eventoDAO.save(evento1);

        //PERSONA
        Persona persona1 = new Persona("Ugo", "Sacco", "ugosacco@gmail.com", LocalDate.parse("1998-10-30"), Sesso.M);
        //personaDAO.save(persona1);

        //PARTECIPAZIONE
       //Partecipazione partecipazione1 = new Partecipazione(persona1,evento1,StatoPartecipazione.DA_CONFERMARE);
        //partecipazioneDAO.save(partecipazione1);

        //CONCERTO
        Concerto concerto1 = new Concerto("Pink Floyd 2026", LocalDate.parse("2026-03-26"), "Il grande ritorno di Gilmour", TipoEvento.PUBBLICO, 40000, locationConcerto, GenereConcerto.ROCK, false);
        locationDAO.save(locationConcerto);
        eventoDAO.save(concerto1);
        //PARTITA DI CALCIO
        PartitaDiCalcio partitaNapoli = new PartitaDiCalcio("Napoli-Juventus", LocalDate.parse("2026-03-26"), "Partita di Serie A", TipoEvento.PUBBLICO, 50000, location1, "Napoli", "Juventus", "Napoli", 3, 0);
        locationDAO.save(location1);
        eventoDAO.save(partitaNapoli);



        entityManager.close();
        entityManagerFactory.close();
    }
}
