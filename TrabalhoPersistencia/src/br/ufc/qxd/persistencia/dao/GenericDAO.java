package br.ufc.qxd.persistencia.dao;

import java.util.List;

public interface GenericDAO <T>{

	public void save(T entity);
	public void Delete(T entity);
	public T select(Object id);
	public List<T> listar();
	public void beginTransaction();
	public void commit();
	public void rollback();
	public void close();
	
	
	
}
