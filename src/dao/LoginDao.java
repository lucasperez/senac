package dao;

import model.Usuario;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.CriadorSessionFactory;
import util.Hibernate;

public class LoginDao {

	private Session session;
	/**
	 * Construtor instancia a session do Hibernate
	 */
	public LoginDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	/**
	 * Loga usuários no sistema
	 * @param usuario
	 * @return {@link Usuario}
	 */
	public Usuario logar(Usuario usuario) {
		return (Usuario) session.createCriteria(Usuario.class)
		.add(Restrictions.eq("login", usuario.getLogin()))
		.add(Restrictions.eq("senha", usuario.getSenha()))
		.uniqueResult();
	}
	
}
