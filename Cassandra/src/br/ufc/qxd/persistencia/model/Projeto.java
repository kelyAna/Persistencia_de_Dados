package br.ufc.qxd.persistencia.model;

import java.util.List;
import java.util.Set;

import com.datastax.oss.driver.api.core.cql.Row;


public class Projeto{

	private int id;
	private String nome;
	private String periodo;
	private int Id_departamento;
	private List<Pesquisador> pesq;

	public Projeto(int id, String nome, String periodo, int id_departamento, List<Pesquisador> pesq) {
		super();
		this.id = id;
		this.nome = nome;
		this.periodo = periodo;
		Id_departamento = id_departamento;
		this.pesq = pesq;
	}

	public Projeto(int id, String nome, String periodo, int id_departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.periodo = periodo;
		Id_departamento = id_departamento;
		//this.pesq = pesq;
	}
	public Projeto() {
		super();
		
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
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	

	public int getIdDepartamento() {
		return Id_departamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		Id_departamento = idDepartamento;
	}

	
	
	public int getId_departamento() {
		return Id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		Id_departamento = id_departamento;
	}

	public List<Pesquisador> getPesq() {
		return pesq;
	}

	public void setPesq(Set<String> pesquisador) {
		this.pesq.add((Pesquisador)pesquisador);
	}

	

	public static Projeto fromRow(Row row) {
		if(row == null) return null;
		Projeto proj = new Projeto();
		
		proj.setId(row.getInt("id"));
		proj.setNome(row.getString("nome"));
		proj.setPeriodo(row.getString("periodo"));
		proj.setIdDepartamento(row.getInt("iddepartamento"));
		proj.setPesq(row.getSet("pesq", String.class));
		
	
		return proj;
	}

	
}
