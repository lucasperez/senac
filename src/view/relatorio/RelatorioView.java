package view.relatorio;

import java.util.Scanner;

import model.Paciente;
import view.AbstractView;
import controller.RelatorioController;


public class RelatorioView extends AbstractView<Paciente> {

private RelatorioController relatorioController;
	
	private Scanner sc;

	public RelatorioView () {
		this.sc = new Scanner(System.in);
		this.relatorioController = RelatorioController.getInstance();
	}
	
	
	@Override
	protected void desenhaTela() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Gerar Relatorio 'Lista de Pacientes em PDF'");
		System.out.println("\t2- Gerar Relatorio 'Historico do Paciente em PDF'");
		System.out.println("\t3- Voltar ao Menu Anterior");
		
		int opcao = sc.nextInt();
		relatorioController.acaoEscolhida(relatorioController.decideAcao(opcao));
	}


	
}
