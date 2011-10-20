package view.main;

import java.util.Scanner;

import view.AbstractView;

import controller.MainController;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MainView extends AbstractView {

	private MainController mainController;
	
	
	public MainView () {
		this.mainController = MainController.getInstance();
		this.sc = new Scanner(System.in);
	}
	
	@Override
	protected void desenhaTela() {
		menuPrincipal();
	}

	private void menuPrincipal() {
		
		System.out.println("Escolha uma opção dos itens abaixo:");
		System.out.println("\t1- Médicos");
		System.out.println("\t2- Pacientes");
		System.out.println("\t3- Atendentes");
		System.out.println("\t4- Consultas");
		System.out.println("\t5- Relatórios");
		System.out.println("\t6- Sair");
		
		int opcao = sc.nextInt();
		
		mainController.acaoEscolhida(mainController.decideAcao(opcao));		
		
	}
}
