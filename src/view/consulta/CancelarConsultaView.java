package view.consulta;

import java.util.Scanner;

import model.Consulta;
import model.Status;
import view.AbstractView;
import controller.ConsultaController;

public class CancelarConsultaView extends AbstractView<Consulta>{

	private Scanner sc;
	private String mensagemIdDaConsulta;
	private String mensagemIdDoStatus;
	private ConsultaController consultaController;
	
	
	public CancelarConsultaView() {
		this.sc = new Scanner(System.in);
		this.consultaController = ConsultaController.getInstance();
	}

	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		defineLabels();
		
		Consulta c = defineModelo();
		
		interfaceUsuario(c);
		
		consultaController.acaoEscolhida("cancelar");
		
	}
	
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemIdDaConsulta = "Digite o id da consulta que deseja cancelar: ";
		mensagemIdDoStatus = "Digite o id do motivo pelo qual deseja cancelar (4- Cancelada a pedido, 5- Cancelada no-show: ";
		
	}
	
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Consulta c) {
		
		System.out.println(mensagemIdDaConsulta);
		Long consultaId = sc.nextLong();
		
		sc.nextLine();
		
		System.out.println(mensagemIdDoStatus);
		Long statusId = sc.nextLong();
		
		c.setId(consultaId);
		
		Status s = new Status();
		s.setId(statusId);
		c.setStatus(s);

		this.setModelo(c);
	}
	/**
	 * Método que define se vai criar um novo modelo ou usar o que já foi setado no controller
	 * @return {@link Consulta}
	 */
	private Consulta defineModelo() {
		Consulta c = null;
		if (this.getModelo() == null) 
			c = new Consulta();
		else {
			c = this.getModelo();
		}
		return c;
	}
}
