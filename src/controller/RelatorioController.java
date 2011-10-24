package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Paciente;
import net.sf.jasperreports.engine.JRException;
import report.Relatorio;
import view.AbstractView;
import dao.ConsultaDao;
import dao.PacienteDao;

public class RelatorioController extends AbstractController<Paciente> {

	private static RelatorioController singleton = null;
	private Map<String,AbstractView<Paciente>> views = new HashMap<String, AbstractView<Paciente>>();
	@SuppressWarnings("rawtypes")
	private Map<String,Relatorio> relatorios = new HashMap<String, Relatorio>();
	private PacienteDao pacienteDao; 
	private ConsultaDao consultaDao;
	/**
	 * Método responsável pela garantia de que só existe 1 único objeto controller dentro do sistema
	 * Uso do padrão singleton para garantir. 	
	 * @return {@link RelatorioController}
	 */		
	public static RelatorioController getInstance()
	{
		if (singleton == null)
			singleton = new RelatorioController();
		
		return singleton;
	}	
	/**
	 * Construtor privado que só pode ser acessado via getInstance
	 */	
	private RelatorioController() {
		this.views = new HashMap<String, AbstractView<Paciente>>();
		acoes.put(0, "relatorioView");
		acoes.put(1, "relatorioPaciente");
		acoes.put(2, "relatorioHistoricoPaciente");
		acoes.put(3, "mainView");
		this.pacienteDao = new PacienteDao();
		this.consultaDao = new ConsultaDao();
	}
	/**
	 * Implementação do método registrarView
	 */
	@Override
	public RelatorioController registrarView(String acao,AbstractView<Paciente> view) {
		this.views.put(acao, view);
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public RelatorioController registrarRelatorio(String acao,Relatorio relatorio) {
		this.relatorios.put(acao, relatorio);
		return this;
	}
	/**
	 * Implementação do método acaoEscolhida
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void acaoEscolhida(String acao) {
		if (acao == null) {
			redirecionaParaMenu();
		}
		else if (acao.equals("relatorioPaciente")) {

			try {
				relatorios.get(acao).gerar("ListarPacientes.jrxml","Lista de Pacientes", "Lista_Pacientes.pdf", pacienteDao.listaPacientes());
			} catch (JRException e) {
				redirecionaParaMenu();
			} catch (SQLException e) {
				redirecionaParaMenu();
			} catch (ClassNotFoundException e) {
				redirecionaParaMenu();
			}finally{
				this.acaoEscolhida("relatorioView");
			}
			
		}
		else if (acao.equals("relatorioHistoricoPaciente")) {
			
			try {
				relatorios.get(acao).gerar("ListarHistoricoPacientes.jrxml","Lista Historico de Pacientes", "Lista_Historico_Pacientes.pdf", consultaDao.listaConsultas());
			} catch (JRException e) {
				redirecionaParaMenu();
			} catch (SQLException e) {
				redirecionaParaMenu();
			} catch (ClassNotFoundException e) {
				redirecionaParaMenu();
			}finally{
				this.acaoEscolhida("relatorioView");
			}
			
			
			
		}
		
		else if (acao.equals("mainView")) {
			MainController.getInstance().acaoEscolhida(acao);
		}
		else {
			//Redireciona para a view baseada na ação
			renderizaView(acao);
		}
	}
	/**
	 * Implementação do método renderizaView
	 */
	public void renderizaView(String acao) {
		try {
			views.get(acao).exibeTela();
		}
		catch(Exception e) {
			redirecionaParaMenu();
		}
	}
	/**
	 * Método que redireciona para o menu principal
	 */
	private void redirecionaParaMenu() {
		
		System.out.println("Ação não permitida !!! Aguarde que estamos redirecionando você para o menu principal");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		this.acaoEscolhida("relatorioView");
	}
		
}
