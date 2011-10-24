package report;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import model.Paciente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioPaciente implements Relatorio<Paciente>{
	
	
	public RelatorioPaciente() {
		
	}

	@Override
	public void gerar(String layout, String titulo, String nomeArquivo,	List<Paciente> listaPacientes) throws JRException, SQLException,ClassNotFoundException {

		// gerando o jasper design
		JasperDesign desenho = JRXmlLoader.load(layout);
		
		// compila o relat�rio
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);
		
		
		// implementa��o da interface JRDataSource para DataSource ResultSet
		JRBeanCollectionDataSource jrRS = new JRBeanCollectionDataSource(listaPacientes);
		
		// executa o relat�rio
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		//parametros.put("subtitulo", titulo);
		
		JasperPrint impressao = JasperFillManager.fillReport(relatorio,	parametros, jrRS);

		//gerando para arquivo em disco
		JasperExportManager.exportReportToPdfFile(impressao, nomeArquivo);

		// exibe o resultado
		JasperViewer.viewReport(impressao, false);
	}

	
}









