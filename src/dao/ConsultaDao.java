package dao;

import java.util.Date;
import java.util.List;

import model.Consulta;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import util.CriadorSessionFactory;
import util.Hibernate;

public class ConsultaDao {
	
	private Session session;
	/**
	 * Construtor instancia a session do Hibernate
	 */
	public ConsultaDao() {
		session = new Hibernate(CriadorSessionFactory.getInstance().getFactory()).getSession();
	}
	
	/**
	 * Lista todos os objetos
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	public List<Consulta> listaConsultas() {
		return (List<Consulta>)session.createCriteria(Consulta.class).addOrder(Order.asc("paciente")).list();
	}

	/**
	 * Lista todos os objetos por perído
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	public List<Consulta> listaConsultas(Date dataIni, Date dataFim) {
		Criteria criteria = session.createCriteria(Consulta.class);
		
		criteria.add(Expression.between("data", dataIni, dataFim));
		
		
		criteria.addOrder(Order.asc("data"));
		return (List<Consulta>)criteria.list();
	}
	/**
	 * Salva o objeto
	 * @param consulta
	 * @return {@link Boolean}
	 */
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
		finally {
			session.clear();
			session.close();
		}
		return false;
	}
	/**
	 * Atualiza o objeto
	 * @param consulta
	 * @return {@link Boolean}
	 */
	public boolean update(Consulta consulta) {
		
		Transaction t = session.beginTransaction();
		try {
			t.begin();
			session.save(consulta.getReceita());
			session.merge(consulta);
			t.commit();
			return true;
		}
		catch(Exception e) {
			t.rollback();
		}
		finally {
			session.clear();
			session.close();
		}
		return false;
	}
	/**
	 * Busca objeto por id
	 * @param id
	 * @return {@link Consulta}
	 */
	public Consulta carregaConsultaPorId(Long id) {
		return (Consulta) session.load(Consulta.class, id);
	}
	/**
	 * Refresh no objeto
	 * @param c
	 * @return {@link Consulta}
	 */
	public Consulta refresh(Consulta c) {
		 session.refresh(c);
		 session.flush();
		 return c;
	}
	/**
	 * Exclui objeto
	 * @param consulta
	 * @return {@link Boolean}
	 */
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
