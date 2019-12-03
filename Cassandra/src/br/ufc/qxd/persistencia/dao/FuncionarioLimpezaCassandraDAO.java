package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.FuncionarioLimpeza;

public interface FuncionarioLimpezaCassandraDAO {
	
	public void insert(FuncionarioLimpeza fl);
	
	public void delete(FuncionarioLimpeza fl);
	
	public void delete(Object id);
	
	public FuncionarioLimpeza find(Object id);
	
	public List<FuncionarioLimpeza> findAll();
	
	public void close();
}
