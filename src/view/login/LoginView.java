package view.login;

import java.util.Scanner;

import model.Usuario;
import view.AbstractView;
import controller.LoginController;

public class LoginView extends AbstractView<Usuario> {

	private LoginController loginController;
	private Scanner scanner;
	
	public LoginView() {
		this.loginController = LoginController.getInstance();
		this.scanner = new Scanner(System.in);
		this.setModelo(new Usuario());
	}
	
	@Override
	protected void desenhaTela() {
		
		System.out.println("Digite seu login: ");
		String login = scanner.next();
		System.out.println("Digite sua senha: ");
		String senha = scanner.next();
		
		this.getModelo().setLogin(login);
		this.getModelo().setSenha(senha);
		
		loginController.acaoEscolhida("login");
	}

}
