package controller;

import java.util.HashMap;
import java.util.Map;

import model.IModel;
import view.AbstractView;


public abstract class AbstractController<T extends IModel> {
	
	protected Map<Integer,String> acoes = new HashMap<Integer, String>();
	
	public abstract void acaoEscolhida(String acao);
	
	public abstract void renderizaView(String acao);
	
	public abstract AbstractController<T>  registrarView(String acao, AbstractView<T> view);
	
	public String decideAcao(Integer opcao) {
		return acoes.get(opcao);
	}
	
}
