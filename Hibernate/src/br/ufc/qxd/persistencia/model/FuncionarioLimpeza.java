package br.ufc.qxd.persistencia.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "func_id")
public class FuncionarioLimpeza extends Funcionario{
	
	private Integer jornadaTrabalho;

	private String cargo;
	
	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private FuncionarioLimpeza gerente;
	
	public FuncionarioLimpeza() {}
	
	public FuncionarioLimpeza(String nome, Endereco endFun, String sexo, String dataAniversario, double salario, Object object, Object object2, Integer jornadaTrabalho2, String cargo2) {
		
	}

	public FuncionarioLimpeza(int id, String nome, Endereco endereco, String sexo, String dataAniversario,
			double salario, List<Dependente> dependentes, Departamento departamento) {
		super(id, nome, endereco, sexo, dataAniversario, salario, dependentes, departamento);
	}
	
	public FuncionarioLimpeza(String nome, Endereco endereco, String sexo, String dataAniversario,
			double salario, List<Dependente> dependentes, Departamento departamento, Integer jornadaTrabalho, String cargo) {
		super(nome, endereco, sexo, dataAniversario, salario, dependentes, departamento);
		this.cargo = cargo;
		this.jornadaTrabalho = jornadaTrabalho;
	}

	public FuncionarioLimpeza(Integer jornadaTrabalho, String cargo, FuncionarioLimpeza gerente) {
		super();
		this.jornadaTrabalho = jornadaTrabalho;
		this.cargo = cargo;
		this.gerente = gerente;
	}
	public FuncionarioLimpeza(Integer jornadaTrabalho, String cargo) {
		this.jornadaTrabalho = jornadaTrabalho;
		this.cargo = cargo;
	}

	public Integer getJornadaTrabalho() {
		return jornadaTrabalho;
	}

	public void setJornadaTrabalho(Integer jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public FuncionarioLimpeza getGerente() {
		return gerente;
	}

	public void setGerente(FuncionarioLimpeza gerente) {
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return "FuncionarioLimpeza [jornadaTrabalho=" + jornadaTrabalho + ", cargo=" + cargo + ", gerente=" + gerente
				+ "]";
	}

	
}
