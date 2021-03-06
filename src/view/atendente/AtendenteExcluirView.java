package view.atendente;

import java.util.Scanner;

import model.Atendente;
import view.AbstractView;
import controller.AtendenteController;

public class AtendenteExcluirView extends AbstractView<Atendente> {

	private AtendenteController atendenteController;
	private Scanner sc;
	
	public AtendenteExcluirView () {
		sc = new Scanner(System.in);
		this.atendenteController = AtendenteController.getInstance();
	}
	
	/**
	 * Implementa��o do m�todo desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		System.out.println("Digite o id do atendente que voc� deseja excluir: ");
		Long id = sc.nextLong();
		Atendente a = new Atendente();
		a.setId(id);
		this.setModelo(a);
		atendenteController.acaoEscolhida("excluir");
	}

}
