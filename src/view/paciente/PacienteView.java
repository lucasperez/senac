package view.paciente;

import java.util.Scanner;

import model.Paciente;
import view.AbstractView;
import controller.PacienteController;


public class PacienteView extends AbstractView<Paciente> {

private PacienteController pacienteController;
private Scanner sc;
	
	public PacienteView () {
		sc = new Scanner(System.in);
		this.pacienteController = PacienteController.getInstance();
	}
	
	
	@Override
	protected void desenhaTela() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Listar Pacientes");
		System.out.println("\t2- Incluir Paciente");
		System.out.println("\t3- Alterar Paciente");
		System.out.println("\t4- Excluir Paciente");
		System.out.println("\t5- Voltar ao Menu Anterior");
		
		int opcao = sc.nextInt();
		pacienteController.acaoEscolhida(pacienteController.decideAcao(opcao));
	}


	
}
