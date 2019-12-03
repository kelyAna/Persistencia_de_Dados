package br.ufc.qxd.persistencia.jpa;

import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.dao.SecretarioDAO;
import br.ufc.qxd.persistencia.model.Secretario;

public class SecretarioJPADAO extends GenericJpaDao<Secretario> implements SecretarioDAO{

	public SecretarioJPADAO() {
		super(Secretario.class);
		// TODO Auto-generated constructor stub
	}

}
