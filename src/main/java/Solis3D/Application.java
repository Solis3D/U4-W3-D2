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

        //EVENTO
        Evento evento1 = new Evento("Napoli - Juventus", LocalDate.parse("2026-03-25"), "Partita di Serie A", TipoEvento.PUBBLICO, 50000,location1);
        //eventoDAO.save(evento1);

        //PERSONA
        Persona persona1 = new Persona("Ugo", "Sacco", "ugosacco@gmail.com", LocalDate.parse("1998-10-30"), Sesso.M);
        //personaDAO.save(persona1);

        //PARTECIPAZIONE
        Partecipazione partecipazione1 = new Partecipazione(persona1,evento1,StatoPartecipazione.DA_CONFERMARE);
        //partecipazioneDAO.save(partecipazione1);


        //GET BY ID
        System.out.println(eventoDAO.getById(UUID.fromString("f2a165fa-5dbc-4ddf-9848-4a0102b4f51b")));
        System.out.println(personaDAO.getById(UUID.fromString("8b588171-e3e7-43e2-9995-69df48c61e96")));
        System.out.println(locationDAO.getById(UUID.fromString("f5acabf9-5c76-4a87-9c54-a5cdce287853")));
        System.out.println(partecipazioneDAO.getById(UUID.fromString("abc9bc63-e00a-427c-97e2-7a938321b0b6")));

        entityManager.close();
        entityManagerFactory.close();
    }
}
