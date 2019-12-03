package br.ufc.qxd.persistencia.model;


import java.util.List;

import com.datastax.oss.driver.api.core.cql.Row;



public class Departamento {
	
	private int id;
	private String nome;
	
	

	public Departamento(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Departamento fromRow(Row row) {
		if(row == null) return null;
		Departamento dep = new Departamento();
		
		dep.setId(row.getInt("id"));
		dep.setNome(row.getString("nome"));
		
		return dep;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
