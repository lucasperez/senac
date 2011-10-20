package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CriacaoBanco {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory factory = CriadorSessionFactory.getInstance().getFactory();
		Session session = new Hibernate(factory).getSession();
		
	}

}
