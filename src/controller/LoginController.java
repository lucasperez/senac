package controller;

import java.util.HashMap;
import java.util.Map;

import model.Usuario;
import view.AbstractView;
import dao.LoginDao;

public class LoginController extends AbstractController<Usuario>{
	
	private Map<String,AbstractView<Usuario>> views = new HashMap<String, AbstractView<Usuario>>();
	private LoginDao loginDao;
	
	// Singleton
	private static LoginController singleton = null;
	/**
	 * Método responsável pela garantia de que só existe 1 único objeto controller dentro do sistema
	 * Uso do padrão singleton para garantir. 	
	 * @return {@link LoginController}
	 */
	public static LoginController getInstance()
	{
		if (singleton == null)
			singleton = new LoginController();
		
		return singleton;
	}	
	/**
	 * Construtor privado que só pode ser acessado via getInstance
	 */	
	private LoginController(){		
		//Mapeamento dos numeros do menu com as ações registradas
		this.acoes.put(0,"loginView");
		loginDao = new LoginDao();
	}
	/**
	 * Implementação do método registrarView
	 */
	@Override
	public AbstractController<Usuario> registrarView(String acao,AbstractView<Usuario> view) {
		this.views.put(acao, view);
		return this;
	}
	/**
	 * Implementação do método acaoEscolhida
	 */
	@Override
	public void acaoEscolhida(String acao) {
		if (acao.equals("login")) {
			if (login(views.get("loginView").getModelo())) {
				MainController.getInstance().acaoEscolhida("mainView");
			}
			else {
				System.out.println("Usuário Inválido");
				renderizaView("loginView");
			}
		}
		else {
			renderizaView("loginView");
		}
	}
	/**
	 * Implementação do método renderizaView
	 */
	@Override
	public void renderizaView(String acao) {
		views.get(acao).exibeTela();
	}
	/**
	 * 
	 * @param u
	 * @return {@link Boolean}
	 */
	public boolean login(Usuario u) {
		if (loginDao.logar(u)!= null)
			return true;
		return false;
	}

	
	
}
