package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import model.Paciente;
import view.AbstractView;
import view.relatorio.RelatorioHistoricoPacienteListView;
import view.relatorio.RelatorioPacienteListView;

public class RelatorioController extends AbstractController<Paciente> {

	private static RelatorioController singleton = null;
	private Map<String,AbstractView<Paciente>> views = new HashMap<String, AbstractView<Paciente>>();
			
	public static RelatorioController getInstance()
	{
		if (singleton == null)
			singleton = new RelatorioController();
		
		return singleton;
	}	
		
	private RelatorioController() {
		this.views = new HashMap<String, AbstractView<Paciente>>();
		acoes.put(0, "relatorioView");
		acoes.put(1, "relatorioPacienteListView");
		acoes.put(2, "relatorioHistoricoPacienteListView");
		acoes.put(3, "mainView");
		}
	
	@Override
	public RelatorioController registrarView(String acao,AbstractView<Paciente> view) {
		this.views.put(acao, view);
		return this;
	}
	
	@Override
	public void acaoEscolhida(String acao) {
		if (acao == null) {
			redirecionaParaMenu();
		}
		else if (acao.equals("relatorioPacienteListView")) {
			RelatorioPacienteListView relatorio = new RelatorioPacienteListView();
			try {
				relatorio.gerar("ListarPacientes.jrxml","Lista de Pacientes");
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
		else if (acao.equals("relatorioHistoricoPacienteListView")) {
			RelatorioHistoricoPacienteListView relatorio = new RelatorioHistoricoPacienteListView();
			try {
				relatorio.gerar("ListarHistoricoPacientes.jrxml","Lista Historico de Pacientes");
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
	
	public void renderizaView(String acao) {
		try {
			views.get(acao).exibeTela();
		}
		catch(Exception e) {
			redirecionaParaMenu();
		}
	}

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
