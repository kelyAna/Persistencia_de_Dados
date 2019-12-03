package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.Projeto;

public interface ProjetoCassandraDAO {
	
	public void insert(Projeto proj);
	
	public void delete(Projeto proj);
	
	public void delete(Object id);
	
	public Projeto find(Object id);
	
	public List<Projeto> findAll();
	
	public void close();
}
