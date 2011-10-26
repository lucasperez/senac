package dao;

import java.util.List;

import model.Atendente;
import model.Medico;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import util.CriadorSessionFactory;
import util.Hibernate;

public class AtendenteDao {
	
	private Session session;
	/**
	 * Construtor instancia a session do Hibernate
	 */
	public AtendenteDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	/**
	 * Lista todos os objetos
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	public List<Atendente> listaAtendentes() {
		return (List<Atendente>)session.createCriteria(Atendente.class).addOrder(Order.asc("nome")).list();
	}
	/**
	 * Salva o objeto
	 * @param medico
	 * @return {@link Boolean}
	 */
	public boolean save(Atendente atendente) {
	
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.saveOrUpdate(atendente);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		return false;
	}
	/**
	 * Busca objeto por id
	 * @param id
	 * @return {@link Medico}
	 */
	public Atendente carregaAtendentePorId(Long id) {
		return (Atendente) session.load(Atendente.class, id);
	}
	/**
	 * Exclui objeto
	 * @param medico
	 * @return {@link Boolean}
	 */
	public boolean excluir(Atendente atendente) {
		
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.delete(atendente);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		return false;
	}
}
