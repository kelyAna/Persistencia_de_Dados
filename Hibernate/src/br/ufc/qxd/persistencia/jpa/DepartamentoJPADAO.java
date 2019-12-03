package br.ufc.qxd.persistencia.jpa;

import java.util.List;

import br.ufc.qxd.persistencia.dao.DepartamentoDAO;
import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.model.Departamento;

public class DepartamentoJPADAO extends GenericJpaDao<Departamento> implements DepartamentoDAO{

	public DepartamentoJPADAO() {
		super(Departamento.class);
	}

	
}
