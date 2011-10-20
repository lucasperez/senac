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
	
	public PacienteDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> listaPacientes() {
		return (List<Paciente>)session.createCriteria(Paciente.class).addOrder(Order.asc("nome")).list();
	}

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

	public Paciente carregaPacientePorId(Long id) {
		return (Paciente) session.load(Paciente.class, id);
	}
	
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
