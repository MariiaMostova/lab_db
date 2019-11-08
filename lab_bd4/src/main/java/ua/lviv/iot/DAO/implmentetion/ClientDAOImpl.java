package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.ClientDAO;
import ua.lviv.iot.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    public void create(Client entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(Client entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Client obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<Client> findAll(Session session) {
        List<Client> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "Client ");
        for (Object obj : query.list()){
            cities.add((Client) obj);
        }
        return cities;
    }

    public Client findById(Integer id, Session session) {
        return session.get(Client.class, id);
    }
}