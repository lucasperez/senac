package view.medico;

import java.util.Scanner;

import model.Medico;
import view.AbstractView;
import controller.MedicoController;

public class MedicoImportarView extends AbstractView<Medico> {

	private MedicoController medicoController;
	private Scanner sc;
	private String caminhoArquivo; 
	
	
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	public MedicoImportarView () {
		sc = new Scanner(System.in);
		this.medicoController = MedicoController.getInstance();
	}
	
	@Override
	protected void desenhaTela() {
		System.out.println("Digite o caminho e nome do arquivo a importar: ");
		caminhoArquivo = sc.next();
		
		medicoController.acaoEscolhida("importar");
	}

}