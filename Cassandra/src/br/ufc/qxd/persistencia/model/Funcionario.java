package br.ufc.qxd.persistencia.model;

import java.util.List;


public class Funcionario {
	

	private int id;
	private String nome;
	private String sexo;
	private String dataAniversario;
	private String salario;
	private String endereco;
	
	

	public Funcionario(int id, String nome, String sexo, String dataAniversario, String salario, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.endereco = endereco;
	}

	public Funcionario() {
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dataAniversario=" + dataAniversario
				+ ", salario=" + salario + ", endereco" + endereco + "]";
	}
	
	
	
	
}
