package br.ufc.qxd.persistencia.jpa;

import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.dao.PesquisadorDAO;
import br.ufc.qxd.persistencia.model.Pesquisador;

public class PesquisadorJPADAO extends GenericJpaDao<Pesquisador> implements PesquisadorDAO{

	public PesquisadorJPADAO() {
		super(Pesquisador.class);
	}

}
