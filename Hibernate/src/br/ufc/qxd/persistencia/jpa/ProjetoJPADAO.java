package br.ufc.qxd.persistencia.jpa;

import br.ufc.qxd.persistencia.dao.GenericJpaDao;

import br.ufc.qxd.persistencia.dao.ProjetoDAO;
import br.ufc.qxd.persistencia.model.Projeto;

public class ProjetoJPADAO extends GenericJpaDao<Projeto> implements ProjetoDAO{

	public ProjetoJPADAO() {
		super(Projeto.class);
		
	}

}
