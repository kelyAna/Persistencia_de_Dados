package br.ufc.qxd.persistencia.model;

import java.util.Date;
import java.util.List;

import com.datastax.oss.driver.api.core.cql.Row;

public class Pesquisador extends Funcionario{

	
	private String areaAtuacao;

	

	public Pesquisador(int id, String nome, String sexo, String dataAniversario, String salario, String endereco,
			String areaAtuacao) {
		//super(id, nome, sexo, dataAniversario, salario, endereco);
		this.areaAtuacao = areaAtuacao;
	}

	public Pesquisador() {
		super();
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}


	public static Pesquisador fromRow(Row row) {
		if(row == null) return null;
		Pesquisador p = new Pesquisador();
		
	
		
		p.setId(row.getInt("id"));
		p.setAreaAtuacao(row.getString("areaatuacao"));
		p.setDataAniversario(row.getString("dataaniversario"));
		p.setEndereco(row.getString("endereco"));
		p.setNome(row.getString("nome"));
		p.setSalario(row.getString("salario"));
		p.setSexo(row.getString("sexo"));
	
		
		return p;
	}
	
	
}
