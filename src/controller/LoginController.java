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
		
	public static LoginController getInstance()
	{
		if (singleton == null)
			singleton = new LoginController();
		
		return singleton;
	}	
		
	private LoginController(){		
		//Mapeamento dos numeros do menu com as ações registradas
		this.acoes.put(0,"loginView");
		loginDao = new LoginDao();
	}
	
	@Override
	public AbstractController<Usuario> registrarView(String acao,AbstractView<Usuario> view) {
		this.views.put(acao, view);
		return this;
	}
	
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
	@Override
	public void renderizaView(String acao) {
		views.get(acao).exibeTela();
	}
	
	public boolean login(Usuario u) {
		if (loginDao.logar(u)!= null)
			return true;
		return false;
	}

	
	
}
