package br.ufc.qxd.persistencia.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Pesquisador_Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projPesq_id")
	private int id;
	private int horasTrabalhadas;
	

	@JoinColumn(name = "projeto_id")
	private int projeto;
	

	@JoinColumn(name = "Pesquisador_id")
	private int pesquisador;

	public Pesquisador_Projeto(int id, int horasTrabalhadas, int projeto, int pesqisador) {
		super();
		this.id = id;
		this.horasTrabalhadas = horasTrabalhadas;
		this.projeto = projeto;
		this.pesquisador = pesqisador;
	}
	public Pesquisador_Projeto(int horasTrabalhadas, int projeto, int pesqisador) {
		this.horasTrabalhadas = horasTrabalhadas;
		this.projeto = projeto;
		this.pesquisador = pesqisador;
	}

	public Pesquisador_Projeto(int id, int horasTrabalhadas) {
		super();
		this.id = id;
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public Pesquisador_Projeto(int id) {
		super();
		this.id = id;
	}

	public Pesquisador_Projeto() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public int getProjeto() {
		return projeto;
	}

	public void setProjeto(int projeto) {
		this.projeto = projeto;
	}

	public int getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(int pesqisador) {
		this.pesquisador = pesqisador;
	}

	@Override
	public String toString() {
		return "Pesquisador_Projeto [id=" + id + ", horasTrabalhadas=" + horasTrabalhadas + ", projeto=" + projeto
				+ ", pesquisador=" + pesquisador + "]";
	}
	
}
