package report;

import java.sql.SQLException;
import java.util.List;

import model.IModel;
import net.sf.jasperreports.engine.JRException;
/**
 * Interface Relatório.
 * Esta interface define o método gerar que deve ser implementado por todos os relatórios do sistema
 * Todo relatório deve ser de um tipo que implemente IModel
 * @author Lucas
 *
 * @param <T>
 */
public interface Relatorio<T extends IModel> {
	
	/**
	 * Método gerar: Este é o método que deve ser escrito nas classes que implementam essa interface
	 * Recebe uma lista de objetos do tipo que implemente IModel e gera o PDF
	 */
	public void gerar(String layout, String titulo, String nomeArquivo, List<T> t) throws JRException, SQLException,ClassNotFoundException;
	
}
