package view.atendente;

import java.util.Scanner;

import model.Atendente;
import view.AbstractView;
import controller.AtendenteController;

public class AtendenteView extends AbstractView<Atendente> {
	
	private AtendenteController atendenteController;
	private Scanner sc;
	
	public AtendenteView () {
		sc = new Scanner(System.in);
		this.atendenteController = AtendenteController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Listar Atendentes");
		System.out.println("\t2- Incluir Atendente");
		System.out.println("\t3- Alterar Atendente");
		System.out.println("\t4- Excluir Atendente");
		System.out.println("\t5- Voltar ao Menu Anterior");
		
		int opcao = sc.nextInt();
		atendenteController.acaoEscolhida(atendenteController.decideAcao(opcao));
	}


	

}
