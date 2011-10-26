package view.relatorio;

import java.util.Scanner;

import model.Relatorios;
import util.DataUtil;
import view.AbstractView;
import controller.RelatorioController;


public class ConsultaAgendadaView extends AbstractView<Relatorios> {

	private RelatorioController relatorioController;
	
	private Scanner sc;
	
	public ConsultaAgendadaView () {
		this.sc = new Scanner(System.in);
		this.relatorioController = RelatorioController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		
		Relatorios r = new Relatorios();
		
		System.out.println("Escolha a data inicial:");
		r.setDataIni(DataUtil.stringBrToDate(sc.next()));
		
		System.out.println("Escolha a data final:");
		r.setDataFim(DataUtil.stringBrToDate(sc.next()));
		
		this.setModelo(r);
		
		relatorioController.acaoEscolhida("relatorioConsultaAgendada");
	}


	
}
