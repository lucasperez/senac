package view.atendente;

import java.util.Scanner;

import model.Atendente;
import view.AbstractView;
import controller.AtendenteController;

public class AtendenteListView extends AbstractView<Atendente> {
	
	private AtendenteController atendenteController;
	private Scanner sc;
	
	public AtendenteListView () {
		sc = new Scanner(System.in);
		this.atendenteController = AtendenteController.getInstance();
	}
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		for (Atendente a:getListModelo()) {
			System.out.println("Id: "+a.getId());
			System.out.println("Nome: "+a.getNome());
			System.out.println("Cpf: "+a.getCpf());
			System.out.println("Login: "+a.getLogin());
			System.out.println("Senha: "+a.getSenha());
			System.out.println("--------------------------");
		}
		System.out.println("Digite ENTER para continuar....");
		@SuppressWarnings("unused")
		String opcao = sc.nextLine();
		atendenteController.acaoEscolhida("atendenteView");
	}

	

	
}
