package util;

import model.Atendente;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Receita;
import model.Status;
import model.Usuario;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CriadorSessionFactory {

	private static CriadorSessionFactory singleton = null;
	
	private SessionFactory factory;
	
	public static CriadorSessionFactory getInstance()
	{
		if (singleton == null)
			singleton = new CriadorSessionFactory();
		
		return singleton;
	}	
	
	private CriadorSessionFactory() {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Atendente.class);
		cfg.addAnnotatedClass(Consulta.class);
		cfg.addAnnotatedClass(Medico.class);
		cfg.addAnnotatedClass(Paciente.class);
		cfg.addAnnotatedClass(Receita.class);
		cfg.addAnnotatedClass(Status.class);
		cfg.addAnnotatedClass(Usuario.class);
		this.factory = cfg.buildSessionFactory();
		
		//Para criar o banco descomente essas linhas
		//SchemaExport se = new SchemaExport(cfg);
		//se.create(true, true);
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}