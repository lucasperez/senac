package main;

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
import view.relatorio.RelatorioView;
import controller.LoginController;
import controller.MainController;
import controller.MedicoController;
import controller.PacienteController;
import controller.RelatorioController;

public class Main {

	public static void main(String[] args) {
		
		//Registro das ações que os controladores poderão realizar 
		LoginController.getInstance().registrarView("loginView", new LoginView());
		
		MainController.getInstance().registrarView("mainView", new MainView());
		
		MainController.getInstance().registrarView("medicoView", new MedicoView());
		
		MainController.getInstance().registrarView("pacienteView", new PacienteView());
		
				
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
		
		RelatorioController.getInstance().registrarView("relatorioView", new RelatorioView());
		RelatorioController.getInstance().registrarView("relatorioPacienteListView", new RelatorioView());
		
		LoginController.getInstance().acaoEscolhida("loginView");

	}

}
