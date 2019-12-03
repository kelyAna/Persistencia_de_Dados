package br.ufc.qxd.persistencia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco {
	
	private String rua;
	private String bairro;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_endereco")
	private int numero;
	private String complemento;
	
	@OneToOne
	@JoinColumn(name="func_id")
	private Funcionario funcionario;

	public Endereco() {
		super();
		
	}
	public Endereco(String rua, String bairro, int numero, String complemento, Funcionario funcionario) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.funcionario = funcionario;
	}
	public Endereco(String rua, String bairro, String complemento, Funcionario funcionario) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.funcionario = funcionario;
	}
	public Endereco(String rua, String bairro, String complemento) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Funcionario getFuncionarios() {
		return funcionario;
	}
	public void setFuncionarios(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", numero=" + numero + ", complemento=" + complemento
				+ ", funcionarios=" + funcionario + "]";
	}
	
}
