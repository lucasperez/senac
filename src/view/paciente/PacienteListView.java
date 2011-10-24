package view.paciente;

import java.util.Scanner;

import model.Paciente;
import view.AbstractView;
import controller.PacienteController;
import util.DataUtil;

public class PacienteListView extends AbstractView<Paciente> {
	
	private PacienteController pacienteController;
	private Scanner sc;
	
	public PacienteListView () {
		sc = new Scanner(System.in);
		this.pacienteController = PacienteController.getInstance();
	}
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		for (Paciente p:getListModelo()) {
			System.out.println("Id: "+p.getId());
			System.out.println("Nome: "+p.getNome());
			System.out.println("Data de Nascimento: "+ DataUtil.dateUsToStringBr(p.getDataNascimento()));
			System.out.println("Plano de Saúde: "+p.getPlanoSaude());
			System.out.println("--------------------------");
		}
		System.out.println("Digite ENTER para continuar....");
		@SuppressWarnings("unused")
		String opcao = sc.nextLine();
		pacienteController.acaoEscolhida("pacienteView");
	}

	

	
}
