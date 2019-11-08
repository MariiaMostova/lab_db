package ua.lviv.iot;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.lviv.iot.view.View;

public class Main {
    private static SessionFactory ourSessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            ourSessionFactory = config.configure().buildSessionFactory();
        } catch (Exception ex) {
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            new View(session).show();

        } finally {
            session.close();
        }
    }
}