package view.paciente;

import java.util.Scanner;

import controller.PacienteController;
import model.Paciente;
import view.AbstractView;

public class PacienteExcluirView extends AbstractView<Paciente> {

	private PacienteController pacienteController;
	private Scanner sc;
	
	public PacienteExcluirView () {
		sc = new Scanner(System.in);
		this.pacienteController = PacienteController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		System.out.println("Digite o id do paciente que você deseja excluir: ");
		Long id = sc.nextLong();
		Paciente m = new Paciente();
		m.setId(id);
		this.setModelo(m);
		pacienteController.acaoEscolhida("excluir");
	}

}
