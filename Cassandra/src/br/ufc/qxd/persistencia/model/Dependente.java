package br.ufc.qxd.persistencia.model;

import com.datastax.oss.driver.api.core.cql.Row;

public class Dependente {
	

	private int id;
	private String dataAniver;
	private String grauParentesco;
	private int idFuncionario;
	private String nome;
	private String sexo;
	
	

	public Dependente(int id, String dataAniver, String grauParentesco, int idFuncionario, String nome, String sexo) {
		super();
		this.id = id;
		this.dataAniver = dataAniver;
		this.grauParentesco = grauParentesco;
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.sexo = sexo;
	}

	public Dependente() {
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

	public String getDataAniver() {
		return dataAniver;
	}

	public void setDataAniver(String dataAniver) {
		this.dataAniver = dataAniver;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	
	
	
	@Override
	public String toString() {
		return "Dependente [id=" + id + ", dataAniver=" + dataAniver + ", grauParentesco=" + grauParentesco
				+ ", idFuncionario=" + idFuncionario + ", nome=" + nome + ", sexo=" + sexo + "]";
	}

	public static Dependente fromRow(Row row) {
		if(row == null) return null;
		Dependente depe = new Dependente();
		
		depe.setId(row.getInt("id"));
		depe.setNome(row.getString("nome"));
		depe.setDataAniver(row.getString("dataaniversario"));
		depe.setGrauParentesco(row.getString("grauparentesco"));
		depe.setSexo(row.getString("sexo"));
		depe.setIdFuncionario(row.getInt("idfuncionario"));
		
	
		return depe;
	}
	
	

}
