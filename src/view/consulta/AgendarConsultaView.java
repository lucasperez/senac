package view.consulta;

import java.util.Scanner;

import model.Atendente;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Status;
import util.DataUtil;
import view.AbstractView;
import controller.ConsultaController;

public class AgendarConsultaView extends AbstractView<Consulta>{

	private Scanner sc;
	private String mensagemData;
	private String mensagemSala;
	private String mensagemMedico;
	private String mensagemAtendente;
	private String mensagemPaciente;
	private ConsultaController consultaController;
	
	
	public AgendarConsultaView() {
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
		
		consultaController.acaoEscolhida("salvar");
		
	}
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemData = "Digite a data da consulta ";
		mensagemSala = "Digite a sala: ";
		mensagemMedico = "Digite o id do médico: ";
		mensagemAtendente = "Digite o id do atendente: ";
		mensagemPaciente = "Digite o id do paciente";
	}
	
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Consulta c) {
		
		
		System.out.println(mensagemData);
		String data = sc.next();
		
		sc.nextLine();
		
		System.out.println(mensagemSala);
		String sala = sc.nextLine();
		
		
		
		System.out.println(mensagemMedico);
		Long medicoId = sc.nextLong();
		
		System.out.println(mensagemAtendente);
		Long atendenteId = sc.nextLong();
		
		System.out.println(mensagemPaciente);
		Long pacienteId = sc.nextLong();

		c.setData(DataUtil.stringBrToDate(data));
		c.setSala(sala);
		
		Medico m = new Medico();
		m.setId(medicoId);
		c.setMedico(m);
		
		Atendente a = new Atendente();
		a.setId(atendenteId);
		c.setAtendente(a);

		Paciente p = new Paciente();
		p.setId(pacienteId);
		c.setPaciente(p);
		
		//Adiciono valor default
		Status s = new Status();
		s.setId(1L);
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
