package dao;

import java.util.List;

import model.Consulta;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import util.CriadorSessionFactory;
import util.Hibernate;

public class ConsultaDao {
	
	private Session session;
	
	public ConsultaDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> listaConsultas() {
		return (List<Consulta>)session.createCriteria(Consulta.class).addOrder(Order.asc("paciente")).list();
	}

	public boolean save(Consulta consulta) {
	
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.saveOrUpdate(consulta);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		return false;
	}

	public Consulta carregaConsultaPorId(Long id) {
		return (Consulta) session.load(Consulta.class, id);
	}
	
	public boolean excluir(Consulta consulta) {
		
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.delete(consulta);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		return false;
	}
}
