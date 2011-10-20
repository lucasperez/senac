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


	
	public PacienteFormView () {
		this.sc = new Scanner(System.in);
		this.pacienteController = PacienteController.getInstance();
	}
	
	@Override
	protected void desenhaTela() {
		
		defineLabels();
		
		Paciente p = defineModelo();
		
		interfaceUsuario(p);
		
		pacienteController.acaoEscolhida("salvar");
		
	}

	private void interfaceUsuario(Paciente p) {
		System.out.println(mensagemNome);
		String nome = sc.next();
		System.out.println(mensagemDataNascimento);
		String data = sc.next();
		System.out.println(mensagemPlanoSaude);
		String plano = sc.next();
		
		p.setNome(nome);
		p.setDataNascimento(DataUtil.stringBrToDate(data));
		p.setPlanoSaude(plano);
		
		this.setModelo(p);
	}

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
