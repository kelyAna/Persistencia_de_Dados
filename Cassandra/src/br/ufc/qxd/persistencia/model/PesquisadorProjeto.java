package br.ufc.qxd.persistencia.model;

import java.time.Instant;

import com.datastax.oss.driver.api.core.cql.Row;

public class PesquisadorProjeto {

	private int id;
	private String horasTrabalhadas;
	private int idProjeto;
	private int idPesquisador;

	
	public PesquisadorProjeto(int id,String horasTrabalhadas, int idProjeto, int idPesquisador){
		super();
		this.id = id;
		this.horasTrabalhadas = horasTrabalhadas;
		this.idProjeto = idProjeto;
		this.idPesquisador = idPesquisador;
		
	}
	
	public PesquisadorProjeto() {
		super();
	
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public int getIdPesquisador() {
		return idPesquisador;
	}

	public void setIdPesquisador(int idPesquisador) {
		this.idPesquisador = idPesquisador;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PesquisadorProjeto [id=" + id + ", horasTrabalhadas=" + horasTrabalhadas + ", idProjeto=" + idProjeto
				+ ", idPesquisador=" + idPesquisador + "]";
	}

	public static PesquisadorProjeto fromRow(Row row) {
		if(row == null) return null;
		PesquisadorProjeto pp = new PesquisadorProjeto();
		
		pp.setId(row.getInt("id"));
		pp.setHorasTrabalhadas(row.getString("horastrabalhadas"));
		pp.setIdPesquisador(row.getInt("idPesquisador"));
		pp.setIdProjeto(row.getInt("idProjeto"));
		
		return pp;
	}
	
}
