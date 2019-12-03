package br.ufc.qxd.persistencia.jpa;

import br.ufc.qxd.persistencia.dao.FuncionarioDAO;
import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.model.Funcionario;

public class FuncionarioJPADAO extends GenericJpaDao<Funcionario> implements FuncionarioDAO{

	public FuncionarioJPADAO() {
		super(Funcionario.class);
	
	}

}
