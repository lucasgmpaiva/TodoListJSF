package br.com.desafio.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure();
					
			SessionFactory factory = cfg.buildSessionFactory();;
			
			return factory;
			
		} catch (Throwable e) {
			System.err.println("Falha na Inicialização da SessionFactory" + e);
			throw new ExceptionInInitializerError(e);
		}
}
}
