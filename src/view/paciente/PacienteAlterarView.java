package view.paciente;

import java.util.Scanner;

import model.Paciente;
import view.AbstractView;
import controller.PacienteController;

public class PacienteAlterarView extends AbstractView<Paciente> {

	private PacienteController pacienteController;
	private Scanner sc;
	
	public PacienteAlterarView () {
		sc = new Scanner(System.in);
		this.pacienteController = PacienteController.getInstance();
	}
	
	@Override
	protected void desenhaTela() {
		System.out.println("Digite o id do paciente que você deseja alterar: ");
		Long id = sc.nextLong();
		Paciente m = new Paciente();
		m.setId(id);
		this.setModelo(m);
		pacienteController.acaoEscolhida("alterar");
	}

}
