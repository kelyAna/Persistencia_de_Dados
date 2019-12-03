package br.ufc.qxd.persistencia.model;
import java.util.List;

import com.datastax.oss.driver.api.core.cql.Row;

public class Secretario extends Funcionario {
	
	private String grauEscolaridade;

	

	public Secretario(int id, String nome, String sexo, String dataAniversario, String salario, String endereco,
			String grauEscolaridade) {
		super(id, nome, sexo, dataAniversario, salario, endereco);
		this.grauEscolaridade = grauEscolaridade;
	}

	public Secretario() {
		super();
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}
	
	

	@Override
	public String toString() {
		return "Secretario [grauEscolaridade=" + grauEscolaridade + super.toString()+ "]";
	}

	public static Secretario fromRow(Row row) {
		if(row == null) return null;
		Secretario sec = new Secretario();
		
		sec.setId(row.getInt("id"));
		sec.setDataAniversario(row.getString("dataaniversario"));
		sec.setEndereco(row.getString("endereco"));
		sec.setGrauEscolaridade(row.getString("grauescolaridade"));
		sec.setNome(row.getString("nome"));
		sec.setSalario(row.getString("salario"));
		sec.setSexo(row.getString("sexo"));

		return sec;
	}
	
	
	

}
