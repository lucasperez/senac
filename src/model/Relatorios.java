package model;

import java.util.Date;

public class Relatorios implements IModel {

	private long idConsulta;
	private String atestado;
	private Date dataIni;
	private Date dataFim;

	public String getAtestado() {
		return atestado;
	}

	public void setAtestado(String atestado) {
		this.atestado = atestado;
	}

	public long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(long id) {
		this.idConsulta = id;
	}

	public Date getDataIni() {
		return dataIni;
	}

	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
