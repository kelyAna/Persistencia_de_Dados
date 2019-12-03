package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.Pesquisador;

public interface PesquisadorCassandraDAO {

	public void insert(Pesquisador p);
	
	public void delete(Pesquisador p);
	
	public void delete(Object id);
	
	public Pesquisador find(Object id);
	
	public List<Pesquisador> findAll();
	
	public void close();
}
