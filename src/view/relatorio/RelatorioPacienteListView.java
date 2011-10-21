package view.relatorio;

import java.sql.SQLException;
import java.util.HashMap;
import dao.PacienteDao;

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

public class RelatorioPacienteListView {
	
	PacienteDao pacienteDao = new PacienteDao();
	
	public RelatorioPacienteListView() {
		
	}

	@SuppressWarnings("deprecation")
	public void gerar(String layout, String titulo) throws JRException, SQLException,ClassNotFoundException {
	
		//List pac = conecta();
		
		// gerando o jasper design
		JasperDesign desenho = JRXmlLoader.load(layout);

		// compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

		// implementação da interface JRDataSource para DataSource ResultSet
		JRBeanCollectionDataSource jrRS = new JRBeanCollectionDataSource(pacienteDao.listaPacientes());
		
		// executa o relatório
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("subtitulo", titulo);
		
		JasperPrint impressao = JasperFillManager.fillReport(relatorio,	parametros, jrRS);

		//gerando para arquivo em disco
		JasperExportManager.exportReportToPdfFile(impressao, "Lista_Pacientes.pdf");


		// exibe o resultado
		JasperViewer viewer = new JasperViewer(impressao, true);
		viewer.show();
	}
		
}










