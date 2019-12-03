package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.model.Secretario;

public interface SecretarioCassandraDAO {
	
	public void insert(Secretario sec);
	
	public void delete(Secretario sec);
	
	public void delete(Object id);
	
	public Secretario find(Object id);
	
	public List<Secretario> findAll();
	
	public void close();
}
