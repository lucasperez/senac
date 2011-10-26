package view.relatorio;

import java.util.Scanner;
import model.Relatorios;

import view.AbstractView;
import controller.RelatorioController;


public class RelatorioView extends AbstractView<Relatorios> {

private RelatorioController relatorioController;
	
	private Scanner sc;

	public RelatorioView () {
		this.sc = new Scanner(System.in);
		this.relatorioController = RelatorioController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Gerar Relatorio 'Lista de Pacientes em PDF'");
		System.out.println("\t2- Gerar Relatorio 'Historico do Paciente em PDF'");
		System.out.println("\t3- Gerar Relatorio 'Consultas agendadas em PDF'");
		System.out.println("\t4- Gerar Relatorio 'Receituario da consulta em PDF'");
		System.out.println("\t5- Gerar Relatorio 'Atestado em PDF'");
		System.out.println("\t6- Voltar ao Menu Anterior");
		
		int opcao = sc.nextInt();
		relatorioController.acaoEscolhida(relatorioController.decideAcao(opcao));
	}


	
}
