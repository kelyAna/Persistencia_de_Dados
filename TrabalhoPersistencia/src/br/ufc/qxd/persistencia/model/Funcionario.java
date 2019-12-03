package br.ufc.qxd.persistencia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "func_id")
	private int id;
	
	private String nome;
	
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario")
	private Endereco endereco;
	
	private String sexo;
	private String dataAniversario;
	private double salario;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Dependente> dependentes;
	
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamento departamento;
	
	public Funcionario(String nome2, Endereco endereco2, String sexo2, String dataAniversario2, double salario2, List<Dependente> dependentes2, Departamento departamento2) {
		super();
	}
	public Funcionario() {

	}
	public Funcionario(int id) {
		this.id = id;
	}

	public Funcionario(int id, String nome, Endereco endereco, String sexo, String dataAniversario, double salario,
			List<Dependente> dependentes,Departamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.dependentes = dependentes;
		this.departamento = departamento;

	}
	public Funcionario( String nome, String sexo, String dataAniversario, double salario,
			Departamento departamento) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.departamento = departamento;

	}
	
	


	public Funcionario(String nome, String sexo, String dataAniversario, double salario) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "\nFuncionario\nId: " + this.id + "Nome: " + this.nome + "\nEndereco: " + this.endereco + "\nSexo: "
				+ this.sexo + "\nData Aniversario: " + this.dataAniversario + "Salario: " + this.salario + this.departamento+"\n\n";
	}
}
