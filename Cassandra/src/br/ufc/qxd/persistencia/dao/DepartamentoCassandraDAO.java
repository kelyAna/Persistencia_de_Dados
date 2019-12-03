package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.Departamento;


public interface DepartamentoCassandraDAO {
 
	
public void insert(Departamento dep);
	
	
	public void delete(Departamento dep);
	
	public void delete(Object numero);
	
	public Departamento find(Object numero);
	
	public List<Departamento> findAll();
	
	public void close();
}
