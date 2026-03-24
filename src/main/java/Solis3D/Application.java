package Solis3D;

import Solis3D.dao.EventoDAO;
import Solis3D.entities.Evento;
import Solis3D.entities.TipoEvento;
import Solis3D.exceptions.NoMatchException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("U4-W3-D2pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(entityManager);

        Evento partita = new Evento("Napoli-Juventus", LocalDate.parse("2026-03-25"),"Partita SERIE A", TipoEvento.PUBBLICO,80000);
        Evento concerto = new Evento("Imagine Dragons Tour", LocalDate.parse("2026-06-14"), "Concerto degli Imagine Dragons a Milano", TipoEvento.PUBBLICO, 100000);
        Evento riunioneCondominio = new Evento("Riunione di Condominio", LocalDate.parse("2026-03-24"), "Riunione del condominio su richiesta del Sig.Ugo", TipoEvento.PRIVATO, 10);

      /*  eventoDAO.save(partita);
        eventoDAO.save(concerto);
        eventoDAO.save(riunioneCondominio);*/

        try{
            Evento partitaFromDB = eventoDAO.getById(1);
            System.out.println(partitaFromDB);
        } catch (NoMatchException e){
            System.out.println(e.getMessage());
        }

        try {
            eventoDAO.delete(3);
        } catch (NoMatchException e) {
            System.out.println(e.getMessage());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
