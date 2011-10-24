package view.consulta;

import java.util.Scanner;

import model.Consulta;
import model.Receita;
import model.Status;
import util.DataUtil;
import view.AbstractView;
import controller.ConsultaController;

public class AtualizarConsultaView extends AbstractView<Consulta>{

	private Scanner sc;
	private String mensagemIdDaConsulta;
	private String mensagemDuracao;
	private String mensagemValidade;
	private String mensagemMedicamento;
	private String mensagemPrescricao;
	private ConsultaController consultaController;
	
	
	public AtualizarConsultaView() {
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
		
		consultaController.acaoEscolhida("atualizar");
		
	}
	
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemIdDaConsulta = "Digite o id da consulta que deseja atualizar: ";
		mensagemDuracao = "Digite a duração: ";
		mensagemValidade = "Digite a validade da receita: ";
		mensagemMedicamento = "Digite o medicamento da receita: ";
		mensagemPrescricao = "Digite a prescrição da receita: ";
		
	}
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Consulta c) {
		
		
		System.out.println(mensagemIdDaConsulta);
		Long consultaId = sc.nextLong();
		
		sc.nextLine();
		
		System.out.println(mensagemDuracao);
		Integer duracao = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Digite os dados da receita....");
		sc.nextLine();
		
		System.out.println(mensagemValidade);
		String validade = sc.next();
		
		sc.nextLine();
		
		System.out.println(mensagemMedicamento);
		String medicamento = sc.nextLine();
		
		System.out.println(mensagemPrescricao);
		String prescricao = sc.nextLine();
		
		c.setId(consultaId);
		c.setDuracao(duracao);
		
		Receita r = new Receita();
		r.setMedicamento(medicamento);
		r.setPrescricao(prescricao);
		r.setValidade(DataUtil.stringBrToDate(validade));
		
		//Status consulta finalizada
		Status s = new Status();
		s.setId(3L);
		
		c.setReceita(r);
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
