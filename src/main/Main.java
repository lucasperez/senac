package main;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import report.RelatorioAtestado;
import report.RelatorioConsultaAgendada;
import report.RelatorioHistoricoPaciente;
import report.RelatorioPaciente;
import report.RelatorioReceituario;
import teste.TestaInternacionalizacao;
import view.atendente.AtendenteAlterarView;
import view.atendente.AtendenteExcluirView;
import view.atendente.AtendenteFormView;
import view.atendente.AtendenteListView;
import view.atendente.AtendenteView;
import view.consulta.AgendarConsultaView;
import view.consulta.AtualizarConsultaView;
import view.consulta.CancelarConsultaView;
import view.consulta.ConsultaView;
import view.login.LoginView;
import view.main.MainView;
import view.medico.MedicoAlterarView;
import view.medico.MedicoExcluirView;
import view.medico.MedicoFormView;
import view.medico.MedicoListView;
import view.medico.MedicoView;
import view.paciente.PacienteAlterarView;
import view.paciente.PacienteExcluirView;
import view.paciente.PacienteFormView;
import view.paciente.PacienteListView;
import view.paciente.PacienteView;
import view.relatorio.AtestadoView;
import view.relatorio.ConsultaAgendadaView;
import view.relatorio.ReceituarioView;
import view.relatorio.RelatorioView;
import controller.AtendenteController;
import controller.ConsultaController;
import controller.LoginController;
import controller.MainController;
import controller.MedicoController;
import controller.PacienteController;
import controller.RelatorioController;

/**
 * 
 * @author Lucas
 * Classe inicial do sistema, nela registramos as views nos respectivos controllers 
 */
public class Main {

	public static void main(String[] args) {
		
		//defino o idioma padrão do sistema
		try {
			defineIdiomaSistema();
		} catch (IOException e) {
			
		}
		
		//Registro das ações que os controladores poderão realizar 
		LoginController.getInstance().registrarView("loginView", new LoginView());
		
		MainController.getInstance().registrarView("mainView", new MainView());
		MainController.getInstance().registrarView("medicoView", new MedicoView());
		MainController.getInstance().registrarView("pacienteView", new PacienteView());
		MainController.getInstance().registrarView("atendenteView", new AtendenteView());
		MainController.getInstance().registrarView("consultaView", new ConsultaView());
		MainController.getInstance().registrarView("relatorioView", new RelatorioView());
		
		
				
		MedicoController.getInstance().registrarView("medicoView", new MedicoView());
		MedicoController.getInstance().registrarView("medicoListView", new MedicoListView());
		MedicoController.getInstance().registrarView("medicoFormView", new MedicoFormView());
		MedicoController.getInstance().registrarView("medicoAlterarView", new MedicoAlterarView());
		MedicoController.getInstance().registrarView("medicoExcluirView", new MedicoExcluirView());
		
		PacienteController.getInstance().registrarView("pacienteView", new PacienteView());
		PacienteController.getInstance().registrarView("pacienteListView", new PacienteListView());
		PacienteController.getInstance().registrarView("pacienteFormView", new PacienteFormView());
		PacienteController.getInstance().registrarView("pacienteAlterarView", new PacienteAlterarView());
		PacienteController.getInstance().registrarView("pacienteExcluirView", new PacienteExcluirView());

		AtendenteController.getInstance().registrarView("atendenteView", new AtendenteView());
		AtendenteController.getInstance().registrarView("atendenteListView", new AtendenteListView());
		AtendenteController.getInstance().registrarView("atendenteFormView", new AtendenteFormView());
		AtendenteController.getInstance().registrarView("atendenteAlterarView", new AtendenteAlterarView());
		AtendenteController.getInstance().registrarView("atendenteExcluirView", new AtendenteExcluirView());
		
		ConsultaController.getInstance().registrarView("consultaView", new ConsultaView());
		ConsultaController.getInstance().registrarView("agendarConsultaView", new AgendarConsultaView());
		ConsultaController.getInstance().registrarView("cancelarConsultaView", new CancelarConsultaView());
		ConsultaController.getInstance().registrarView("atualizarConsultaView", new AtualizarConsultaView());
		
		RelatorioController.getInstance().registrarView("relatorioView", new RelatorioView());
		RelatorioController.getInstance().registrarView("consultaAgendadaView", new ConsultaAgendadaView());
		RelatorioController.getInstance().registrarView("receituarioView", new ReceituarioView());
		RelatorioController.getInstance().registrarView("atestadoView", new AtestadoView());
		RelatorioController.getInstance().registrarRelatorio("relatorioPaciente", new RelatorioPaciente());
		RelatorioController.getInstance().registrarRelatorio("relatorioHistoricoPaciente", new RelatorioHistoricoPaciente());
		RelatorioController.getInstance().registrarRelatorio("relatorioConsultaAgendada", new RelatorioConsultaAgendada());	
		RelatorioController.getInstance().registrarRelatorio("relatorioReceituario", new RelatorioReceituario());
		RelatorioController.getInstance().registrarRelatorio("relatorioAtestado", new RelatorioAtestado());
		
		LoginController.getInstance().acaoEscolhida("loginView");

	}

	private static void defineIdiomaSistema() throws IOException {
		Properties p = new Properties();
		p.load(TestaInternacionalizacao.class.getClassLoader().getResourceAsStream("consultorio.properties"));
		Locale locale = new Locale(p.getProperty("idiomaPadrao"),p.getProperty("paisPadrao"));
		Locale.setDefault(locale);
	}
}
