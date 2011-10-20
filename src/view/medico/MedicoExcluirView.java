package view.medico;

import java.util.Scanner;

import controller.MedicoController;
import model.Medico;
import view.AbstractView;

public class MedicoExcluirView extends AbstractView<Medico> {

	private MedicoController medicoController;
	
	public MedicoExcluirView () {
		this.sc = new Scanner(System.in);
		this.medicoController = MedicoController.getInstance();
	}
	
	@Override
	protected void desenhaTela() {
		System.out.println("Digite o id do médico que você deseja excluir: ");
		Long id = sc.nextLong();
		Medico m = new Medico();
		m.setId(id);
		this.setModelo(m);
		medicoController.acaoEscolhida("excluir");
	}

}
