package view.consulta;

import java.util.Scanner;

import controller.ConsultaController;

import model.Consulta;
import view.AbstractView;


public class ConsultaView extends AbstractView<Consulta> {
	
	private Scanner sc;
	private ConsultaController consultaController;

	public ConsultaView () {
		this.sc = new Scanner(System.in);
		this.consultaController = ConsultaController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Agendar Consulta");
		System.out.println("\t2- Cancelar Consulta");
		System.out.println("\t3- Atualizar Consulta");
		System.out.println("\t4- Voltar ao Menu Anterior");
		
		int opcao = sc.nextInt();
		consultaController.acaoEscolhida(consultaController.decideAcao(opcao));
	}


	
}
