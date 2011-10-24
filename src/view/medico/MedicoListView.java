package view.medico;

import java.util.Scanner;

import model.Medico;
import view.AbstractView;
import controller.MedicoController;

public class MedicoListView extends AbstractView<Medico> {
	
	private MedicoController medicoController;
	private Scanner sc;
	
	public MedicoListView () {
		sc = new Scanner(System.in);
		this.medicoController = MedicoController.getInstance();
	}
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		for (Medico m:getListModelo()) {
			System.out.println("Id: "+m.getId());
			System.out.println("Nome: "+m.getNome());
			System.out.println("Crm: "+m.getCrm());
			System.out.println("Especialidade: "+m.getEspecialidade());
			System.out.println("Login: "+m.getLogin());
			System.out.println("Senha: "+m.getSenha());
			System.out.println("--------------------------");
		}
		System.out.println("Digite ENTER para continuar....");
		@SuppressWarnings("unused")
		String opcao = sc.nextLine();
		medicoController.acaoEscolhida("medicoView");
	}

	

	
}
