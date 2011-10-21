package controller;

import java.util.HashMap;
import java.util.Map;

import view.AbstractView;

@SuppressWarnings("rawtypes")
public class MainController extends AbstractController{

	private static MainController singleton = null;
	private Map<String,AbstractView> views = new HashMap<String, AbstractView>();
		
	public static MainController getInstance()
	{
		if (singleton == null)
			singleton = new MainController();
		
		return singleton;
	}	
		
	@SuppressWarnings("unchecked")
	private MainController() {
		//Mapeamento dos numeros do menu com as ações registradas
		this.acoes.put(0,"mainView");
		this.acoes.put(1,"medicoView");
		this.acoes.put(2,"pacienteView");
		this.acoes.put(5, "relatorioView");
		this.acoes.put(6,"sair");
	}
	
	@Override
	public MainController registrarView(String acao, AbstractView view) {
		this.views.put(acao, view);
		return this;
	}
	

	@Override
	public void acaoEscolhida(String acao) {
		if (acao.equalsIgnoreCase("sair")) {
			System.out.println("Seção finalizada!");
			System.exit(0);
		}
		else {
			renderizaView(acao);
		}
	}

	@Override
	public void renderizaView(String acao) {
		try {
			views.get(acao).exibeTela();
		}
		catch(Exception e) {
			redirecionaParaMenu();
		}
	}
	
	private void redirecionaParaMenu() {
		
		System.out.println("Ação não permitida !!! Aguarde que estamos redirecionando você para o menu principal");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		this.acaoEscolhida("mainView");
	}

	
}
