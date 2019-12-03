package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.Dependente;

public interface DependenteCassandraDAO {
	
	public void insert(Dependente depe);
	
	public void delete(Dependente depe);
	
	public void delete(Object id);
	
	public Dependente find(Object id);
	
	public List<Dependente> findAll();
	
	public void close();
}
