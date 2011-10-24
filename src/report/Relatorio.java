package report;

import java.sql.SQLException;
import java.util.List;

import model.IModel;
import net.sf.jasperreports.engine.JRException;

public interface Relatorio<T extends IModel> {

	public void gerar(String layout, String titulo, String nomeArquivo, List<T> t) throws JRException, SQLException,ClassNotFoundException;
	
}
