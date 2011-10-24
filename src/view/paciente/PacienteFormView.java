package view.paciente;

import java.util.Scanner;

import model.Paciente;
import util.DataUtil;
import view.AbstractView;
import controller.PacienteController;

public class PacienteFormView extends AbstractView<Paciente> {
	
	private PacienteController pacienteController;
	private String mensagemNome;
	private String mensagemDataNascimento;
	private String mensagemPlanoSaude;
	private Scanner sc;

	public PacienteFormView () {
		sc = new Scanner(System.in);
		this.pacienteController = PacienteController.getInstance();
	}
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		defineLabels();
		
		Paciente p = defineModelo();
		
		interfaceUsuario(p);
		
		pacienteController.acaoEscolhida("salvar");
		
	}
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Paciente p) {
		System.out.println(mensagemNome);
		String nome = sc.nextLine();
		
		sc.nextLine();
		
		System.out.println(mensagemDataNascimento);
		String data = sc.next();
		
		System.out.println(mensagemPlanoSaude);
		String plano = sc.nextLine();
		
		sc.nextLine();
		
		p.setNome(nome);
		p.setDataNascimento(DataUtil.stringBrToDate(data));
		p.setPlanoSaude(plano);
		
		this.setModelo(p);
	}
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemNome 			= "Digite o nome: ";
		mensagemDataNascimento 	= "Digite a data de nascimento (dd/mm/aaaa): ";
		mensagemPlanoSaude		= "Digite o plano de saúde: ";
		
		if (this.getModelo() != null) { 
			mensagemNome+="("+this.getModelo().getNome()+")"; 
			mensagemDataNascimento+="("+this.getModelo().getDataNascimento()+")";
			mensagemPlanoSaude+="("+this.getModelo().getPlanoSaude()+")";			
		}
	}
	/**
	 * Método que define se vai criar um novo modelo ou usar o que já foi setado no controller
	 * @return {@link Paciente}
	 */
	private Paciente defineModelo() {
		Paciente p = null;
		if (this.getModelo() == null) 
			p = new Paciente();
		else {
			p = this.getModelo();
		}
		return p;
	}	

}
