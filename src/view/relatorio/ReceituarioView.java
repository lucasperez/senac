package view.relatorio;

import java.util.Scanner;

import model.Relatorios;
import view.AbstractView;
import controller.RelatorioController;;

public class ReceituarioView extends AbstractView<Relatorios>{

	private Scanner sc;
	private String mensagemIdDaConsulta;
	private RelatorioController relatorioController;
	
	
	public ReceituarioView() {
		this.sc = new Scanner(System.in);
		this.relatorioController = RelatorioController.getInstance();
	}

	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		defineLabels();
		
		Relatorios r = defineModelo();
		
		interfaceUsuario(r);
		
		relatorioController.acaoEscolhida("relatorioReceituario");
		
	}
	
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemIdDaConsulta = "Digite o id da consulta que deseja: ";
		
	}
	
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Relatorios r) {
		
		System.out.println(mensagemIdDaConsulta);
		Long consultaId = sc.nextLong();
		
		
		r.setIdConsulta(consultaId);
		
		this.setModelo(r);
	}
	/**
	 * Método que define se vai criar um novo modelo ou usar o que já foi setado no controller
	 * @return {@link Consulta}
	 */
	private Relatorios defineModelo() {
		Relatorios c = null;
		if (this.getModelo() == null) 
			c = new Relatorios();
		else {
			c = this.getModelo();
		}
		return c;
	}
}
