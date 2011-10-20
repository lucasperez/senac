package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Medico;
import view.AbstractView;
import dao.MedicoDao;

public class MedicoController extends AbstractController<Medico> {

	private static MedicoController singleton = null;
	private Map<String,AbstractView<Medico>> views = new HashMap<String, AbstractView<Medico>>();
	private MedicoDao medicoDao;
		
	public static MedicoController getInstance()
	{
		if (singleton == null)
			singleton = new MedicoController();
		
		return singleton;
	}	
		
	private MedicoController() {
		this.views = new HashMap<String, AbstractView<Medico>>();
		acoes.put(0, "medicoView");
		acoes.put(1, "medicoListView");
		acoes.put(2, "medicoFormView");
		acoes.put(3, "medicoAlterarView");
		acoes.put(4, "medicoExcluirView");
		acoes.put(5, "mainView");
		medicoDao = new MedicoDao();
	}
	
	@Override
	public MedicoController registrarView(String acao,AbstractView<Medico> view) {
		this.views.put(acao, view);
		return this;
	}
	
	@Override
	public void acaoEscolhida(String acao) {
		if (acao == null) {
			redirecionaParaMenu();
		}
		else if (acao.equals("medicoFormView")) {
			views.get(acao).setListModelo(null);
			views.get(acao).setModelo(null);
			renderizaView(acao);
		}
		else if (acao.equals("medicoListView")) {
			views.get(acao).setListModelo(listaMedicos());
			renderizaView(acao);
		}
		else if (acao.equals("salvar")) {
			if (salvarMedico(views.get("medicoFormView").getModelo()));
			renderizaView("medicoView");
			
		}
		else if (acao.equals("alterar")) {
			views.get("medicoFormView").setModelo(carregaMedicoPorId(views.get("medicoAlterarView").getModelo().getId()));
			renderizaView("medicoFormView");
			
		}
		else if (acao.equals("excluir")) {
			if (excluirMedico(carregaMedicoPorId(views.get("medicoExcluirView").getModelo().getId())));
			renderizaView("medicoView");
			
			
		}
		else if (acao.equals("mainView")) {
			MainController.getInstance().acaoEscolhida(acao);
		}
		else {
			//Redireciona para a view baseada na ação
			renderizaView(acao);
		}
	}
	
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
		
		this.acaoEscolhida("medicoView");
	}
	
	private List<Medico> listaMedicos(){
		return medicoDao.listaMedicos();
	}
	
	public boolean salvarMedico(Medico medico) {
		if (medicoDao.save(medico)) 
			return true;
		return false;
		
	}

	public Medico carregaMedicoPorId(Long id) {
		return medicoDao.carregaMedicoPorId(id);
		
	}
	
	public boolean excluirMedico(Medico medico) {
		if (medicoDao.excluir(medico)) 
			return true;
		return false;
		
	}
	
}
