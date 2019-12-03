package br.ufc.qxd.persistencia.jpa;

import br.ufc.qxd.persistencia.dao.EnderecoDAO;
import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.model.Endereco;

public class EnderecoJPADAO extends GenericJpaDao<Endereco> implements EnderecoDAO{

	public EnderecoJPADAO() {
		super(Endereco.class);
		
	}

}
