package dao;

import java.util.List;

import model.Paciente;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import util.CriadorSessionFactory;
import util.Hibernate;

public class PacienteDao {
	
	private Session session;
	/**
	 * Construtor instancia a session do Hibernate
	 */
	public PacienteDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	/**
	 * Lista todos os objetos
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	public List<Paciente> listaPacientes() {
		return (List<Paciente>)session.createCriteria(Paciente.class).addOrder(Order.asc("nome")).list();
	}
	/**
	 * Salva o objeto
	 * @param paciente
	 * @return {@link Boolean}
	 */
	public boolean save(Paciente paciente) {
	
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.saveOrUpdate(paciente);
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
	 * @return {@link Paciente}
	 */
	public Paciente carregaPacientePorId(Long id) {
		return (Paciente) session.load(Paciente.class, id);
	}
	/**
	 * Exclui objeto
	 * @param paciente
	 * @return {@link Boolean}
	 */
	public boolean excluir(Paciente paciente) {
		
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.delete(paciente);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		return false;
	}
}
