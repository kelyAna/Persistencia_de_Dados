package br.ufc.qxd.persistencia.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.datastax.oss.driver.api.core.cql.Row;

public class FuncionarioLimpeza extends Funcionario{
	
	private int jornadaTrabalho;
	private String cargo;
	private int CodGerente;
	
	

 
	public FuncionarioLimpeza(int id, String nome, String sexo, String dataAniversario, String salario, String endereco,
			int jornadaTrabalho, String cargo, int codGerente) {
		super(id, nome, sexo, dataAniversario, salario, endereco);
		this.jornadaTrabalho = jornadaTrabalho;
		this.cargo = cargo;
		CodGerente = codGerente;
	}

	public FuncionarioLimpeza() {
		
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


	public int getCodGerente() {
		return CodGerente;
	}


	public void setCodGerente(int codGerente) {
		CodGerente = codGerente;
	}
	
	

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}

	@Override
	public String getSexo() {
		// TODO Auto-generated method stub
		return super.getSexo();
	}

	@Override
	public void setSexo(String sexo) {
		// TODO Auto-generated method stub
		super.setSexo(sexo);
	}

	@Override
	public String getDataAniversario() {
		// TODO Auto-generated method stub
		return super.getDataAniversario();
	}

	@Override
	public void setDataAniversario(String dataAniversario) {
		// TODO Auto-generated method stub
		super.setDataAniversario(dataAniversario);
	}

	@Override
	public String getSalario() {
		// TODO Auto-generated method stub
		return super.getSalario();
	}

	@Override
	public void setSalario(String salario) {
		// TODO Auto-generated method stub
		super.setSalario(salario);
	}




	@Override
	public String toString() {
		return super.toString()+"FuncionarioLimpeza [jornadaTrabalho=" + jornadaTrabalho + ", cargo=" + cargo + ", CodGerente="
				+ CodGerente + "]";
	}

	public void setJornadaTrabalho(int jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}

	public static FuncionarioLimpeza fromRow(Row row) {
		if(row == null) return null;
		FuncionarioLimpeza fl = new FuncionarioLimpeza();
		
		fl.setId(row.getInt("id"));
		fl.setCargo(row.getString("cargo"));
		fl.setCodGerente(row.getInt("codGerente"));
		fl.setDataAniversario(row.getString("dataAniversario"));
		fl.setEndereco(row.getString("endereco"));
		fl.setJornadaTrabalho(row.getInt("jornadaTrabalho"));
		fl.setNome(row.getString("nome"));
		fl.setSalario(row.getString("salario"));
		fl.setSexo(row.getString("sexo"));
	
		return fl;
	}
	
	
}
