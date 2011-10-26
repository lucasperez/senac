package view.relatorio;

import java.util.Scanner;

import model.Relatorios;
import view.AbstractView;
import controller.RelatorioController;;

public class AtestadoView extends AbstractView<Relatorios>{

	private Scanner sc;
	private String mensagemIdDaConsulta;
	private String mensagemAtestadoDaConsulta;
	private RelatorioController relatorioController;
	
	
	public AtestadoView() {
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
		
		relatorioController.acaoEscolhida("relatorioAtestado");
		
	}
	
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemIdDaConsulta = "Digite o id da consulta que deseja: ";
		mensagemAtestadoDaConsulta= "Digite o atestado da consulta que deseja: ";
	}
	
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Relatorios r) {
		
		System.out.println(mensagemIdDaConsulta);
		Long consultaId = sc.nextLong();
		
		sc.nextLine();
		
		System.out.println(mensagemAtestadoDaConsulta);
		String atestado = sc.nextLine();		
		
		r.setIdConsulta(consultaId);
		r.setAtestado(atestado);
		
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
