package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory entityManagerFactory;

    static {
    	entityManagerFactory = Persistence.createEntityManagerFactory("DESAFIOMV");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
    	entityManagerFactory.close();
    }
}
