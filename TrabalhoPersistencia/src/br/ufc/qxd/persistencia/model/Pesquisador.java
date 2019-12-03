package br.ufc.qxd.persistencia.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.sun.istack.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "func_id")
public class Pesquisador extends Funcionario{

	
	private String areaAtuacao;


	public Pesquisador() {

	}
	
	public Pesquisador(int id, String nome, Endereco endereco, String sexo, String dataAniversario, double salario,
			List<Dependente> dependentes, Departamento departamento) {
		super(id, nome, endereco, sexo, dataAniversario, salario, dependentes, departamento);
	}
	
	public Pesquisador( String nome, Endereco endereco, String sexo, String dataAniversario, double salario,
			List<Dependente> dependentes, Departamento departamento, String areaAtuacao) {
		super( nome, endereco, sexo, dataAniversario, salario, dependentes, departamento);
		this.areaAtuacao = areaAtuacao;
	}

	public Pesquisador(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	
	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	@Override
	public String toString() {
		return super.toString() + " > Pesquisador [areaAtuacao=" + areaAtuacao + "]";
	}
	
}
