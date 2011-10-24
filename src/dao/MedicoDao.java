package dao;

import java.util.List;

import model.Medico;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import util.CriadorSessionFactory;
import util.Hibernate;

public class MedicoDao {
	
	private Session session;
	/**
	 * Construtor instancia a session do Hibernate
	 */
	public MedicoDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	/**
	 * Lista todos os objetos
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	public List<Medico> listaMedicos() {
		return (List<Medico>)session.createCriteria(Medico.class).addOrder(Order.asc("nome")).list();
	}
	/**
	 * Salva o objeto
	 * @param medico
	 * @return {@link Boolean}
	 */
	public boolean save(Medico medico) {
	
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.saveOrUpdate(medico);
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
	public Medico carregaMedicoPorId(Long id) {
		return (Medico) session.load(Medico.class, id);
	}
	/**
	 * Exclui objeto
	 * @param medico
	 * @return {@link Boolean}
	 */
	public boolean excluir(Medico medico) {
		
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.delete(medico);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		return false;
	}
}
