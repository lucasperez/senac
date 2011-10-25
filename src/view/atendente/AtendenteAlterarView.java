package view.atendente;

import java.util.Scanner;

import model.Atendente;
import view.AbstractView;
import controller.AtendenteController;

public class AtendenteAlterarView extends AbstractView<Atendente> {

	private AtendenteController atendenteController;
	private Scanner sc;
	
	public AtendenteAlterarView () {
		sc = new Scanner(System.in);
		this.atendenteController = AtendenteController.getInstance();
	}
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		System.out.println("Digite o id do atendente que você deseja alterar: ");
		Long id = sc.nextLong();
		Atendente a = new Atendente();
		a.setId(id);
		this.setModelo(a);
		atendenteController.acaoEscolhida("alterar");
	}

}
