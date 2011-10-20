package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hibernate {

	private final SessionFactory factory;
	private Session session;
	
	public Hibernate(SessionFactory factory) {
		this.factory = factory;
		this.session = factory.openSession();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public void fechaConexao() {
		this.session.close();
	}
	
	
}
