package br.ufc.qxd.persistencia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="func_id")
public class Secretario extends Funcionario {
	private String grauEscolaridade;

	
	public Secretario() {
		
	}
	
	public Secretario(int id, String nome, Endereco endereco, String sexo, String dataAniversario, double salario,
			List<Dependente> dependentes, Departamento departamento) {
		super(id, nome, endereco, sexo, dataAniversario, salario, dependentes, departamento);
		
	}
	public Secretario(String nome, Endereco endereco, String sexo, String dataAniversario, double salario,
			List<Dependente> dependentes, Departamento departamento, String grauEsc) {
		super(nome, endereco, sexo, dataAniversario, salario, dependentes, departamento);
		this.grauEscolaridade = grauEsc;
		
	}
	
	public Secretario(String grauEscolaridade) {
		super();
		this.grauEscolaridade = grauEscolaridade;
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

	@Override
	public String toString() {
		return "Secretario [grauEscolaridade=" + grauEscolaridade + ", getGrauEscolaridade()=" + getGrauEscolaridade()
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getEndereco()=" + getEndereco()
				+ ", getSexo()=" + getSexo() + ", getDataAniversario()=" + getDataAniversario() + ", getSalario()="
				+ getSalario() + ", getDependentes()=" + getDependentes() + ", getDepartamento()=" + getDepartamento()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
