package controller;

import java.util.HashMap;
import java.util.Map;

import model.IModel;
import view.AbstractView;

/**
 * 
 * @author Lucas
 *
 * @param <T>
 * 
 * Classe responsável pela abstração dos controllers. Uma classe para ser um controller deve extender dessa classe
 * Usamos o tipo Paremtrizado T para definição do tipo do controller que se refere. No caso todos deversão
 * ser de algum tipo que implemente IModel.
 */
public abstract class AbstractController<T extends IModel> {
	/**
	 * Atributo que contém todas as ações possíveis de serem executadas no controller
	 */
	protected Map<Integer,String> acoes = new HashMap<Integer, String>();
	
	/**
	 * Método que deve ser sobreescrito nos controllers específicos
	 * Deve ser passado uma string contendo a acao e esta acao deve estar mapeada
	 * no mapa do atributo acoes
	 * @param acao
	 */
	public abstract void acaoEscolhida(String acao);
	
	/**
	 * Método que deve ser sobreescrito nos controllers específicos.
	 * Nele conterá a lógica de renderização da view.
	 * @param acao
	 */
	public abstract void renderizaView(String acao);
	
	/**
	 * Método que deve ser sobreescrito nos controllers específicos.
	 * Este método é responsável por registrar todas as views a que os controllers
	 * terão acesso. Ele recebe a ação e uma instância da classe de view.
	 * @param acao
	 * @param view
	 * @return
	 */
	public abstract AbstractController<T>  registrarView(String acao, AbstractView<T> view);
	
	/**
	 * Método que retorna a ação baseada no número escolhido no menu 
	 * @param opcao
	 * @return
	 */
	public String decideAcao(Integer opcao) {
		return acoes.get(opcao);
	}
	
}
