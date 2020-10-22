package br.com.desafio.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	//Testando conexão com banco
	@Test
	public void connect() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
