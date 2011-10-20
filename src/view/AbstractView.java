package view;

import java.util.List;
import java.util.Scanner;

import model.IModel;

public abstract class AbstractView<T extends IModel>  {
	
	//Usado em telas que precisamos exibir mais de 1 elemento
	private List<T> listModelo;
	
	//Usado em telas com um único elemento
	private T modelo;
	
	public void exibeTela() {
		desenhaCabecalho();
		desenhaTela();
	}
	
	protected abstract void desenhaTela();
	
	private void limpaTela() {
		for(int i=0; i<25; i++) {
			System.out.println();
		}
	}
	
	private void desenhaCabecalho() {
		limpaTela();
		System.out.println("-----------------------------------------------");
		System.out.println("SISTEMA DE CONSULTÓRIO MÉDICO");
		System.out.println("-----------------------------------------------");
	}

	public List<T> getListModelo() {
		return listModelo;
	}

	public void setListModelo(List<T> listModelo) {
		this.listModelo = listModelo;
	}

	public T getModelo() {
		return modelo;
	}

	public void setModelo(T modelo) {
		this.modelo = modelo;
	}
	
}
