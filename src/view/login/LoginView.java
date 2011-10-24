package view.login;

import java.util.Locale;
import java.util.ResourceBundle;
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
	
	/**
	 * Implementação do método desenhaTela
	 */
	@Override
	protected void desenhaTela() {
		
		ResourceBundle rb = ResourceBundle.getBundle("resources.MessagesBundle", Locale.getDefault());
		System.out.println(rb.getString("labelLogin"));
		String login = scanner.next();
		System.out.println(rb.getString("labelSenha"));
		String senha = scanner.next();
		
		this.getModelo().setLogin(login);
		this.getModelo().setSenha(senha);
		
		loginController.acaoEscolhida("login");
	}

}
