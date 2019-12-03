package br.ufc.qxd.persistencia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d_id")
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Projeto> projetos;

	@OneToMany(mappedBy = "departamento",cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
	public Departamento() {
		super();
	}

	public Departamento(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		
	}

	
	public Departamento(int id, String nome, List<Projeto> projetos, List<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.projetos = projetos;
		this.funcionarios = funcionarios;
	}
	
	public Departamento(int id) {
		this.id = id;
	}
	
	public Departamento(String nome) {
		this.nome = nome;
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

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + "]";
	}

	

}
