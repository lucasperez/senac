package view.medico;

import java.util.Scanner;

import model.Medico;
import view.AbstractView;
import controller.MedicoController;

public class MedicoView extends AbstractView<Medico> {
	
	private MedicoController medicoController;
	private Scanner sc;
	
	public MedicoView () {
		sc = new Scanner(System.in);
		this.medicoController = MedicoController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Listar Médicos");
		System.out.println("\t2- Incluir Médico");
		System.out.println("\t3- Alterar Médico");
		System.out.println("\t4- Excluir Médico");
		System.out.println("\t5- Importar Médico do CSV");
		System.out.println("\t6- Voltar ao Menu Anterior");
		
		int opcao = sc.nextInt();
		medicoController.acaoEscolhida(medicoController.decideAcao(opcao));
	}


	

}
