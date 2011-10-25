package view.atendente;

import java.util.Scanner;

import model.Atendente;
import model.Medico;
import view.AbstractView;
import controller.AtendenteController;

public class AtendenteFormView extends AbstractView<Atendente> {
	
	private AtendenteController atendenteController;
	private String mensagemNome;
	private String mensagemCpf;
	private String mensagemLogin;
	private String mensagemSenha;
	private Scanner sc;
	
	public AtendenteFormView () {
		sc = new Scanner(System.in);
		this.atendenteController = AtendenteController.getInstance();
	}
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		defineLabels();
		
		Atendente a = defineModelo();
		
		interfaceUsuario(a);
		
		atendenteController.acaoEscolhida("salvar");
		
	}
	/**
	 * Método que escreve na tela, recupera dados digitados e popula modelo (neste caso de consulta)
	 * @param c
	 */
	private void interfaceUsuario(Atendente a) {
		System.out.println(mensagemNome);
		String nome = sc.nextLine();
		sc.nextLine();
		
		System.out.println(mensagemCpf);
		String cpf = sc.next();
		
		sc.nextLine();
		
		System.out.println(mensagemLogin);
		String login = sc.next();
		System.out.println(mensagemSenha);
		String senha = sc.next();
			
		a.setCpf(cpf);
		a.setLogin(login);
		a.setNome(nome);
		a.setSenha(senha);
		
		this.setModelo(a);
	}
	/**
	 * Método usado apenas para definir as labels da tela
	 */
	private void defineLabels() {
		mensagemNome = "Digite o nome ";
		mensagemCpf = "Digite o cpf: ";
		mensagemLogin = "Digite o login: ";
		mensagemSenha = "Digite o senha: ";
		
		if (this.getModelo() != null) { 
			mensagemNome+="("+this.getModelo().getNome()+")"; 
			mensagemCpf+="("+this.getModelo().getCpf()+")";
			mensagemLogin+="("+this.getModelo().getLogin()+")";
			mensagemSenha+="("+this.getModelo().getSenha()+")";
		}
	}
	/**
	 * Método que define se vai criar um novo modelo ou usar o que já foi setado no controller
	 * @return {@link Medico}
	 */
	private Atendente defineModelo() {
		Atendente a = null;
		if (this.getModelo() == null) 
			a = new Atendente();
		else {
			a = this.getModelo();
		}
		return a;
	}
}
