package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.PesquisadorProjeto;



public interface PesquisadorProjetoCassandraDAO {

	public void insert(PesquisadorProjeto pesquisadorProjeto);
	
	
	
	public void delete(PesquisadorProjeto pesquisadorProjeto);
	
	public void delete(Object id);
	
	public PesquisadorProjeto find(Object id);
	
	public List<PesquisadorProjeto> findAll();
	
	public void close();
}
