package br.ufc.qxd.persistencia.jpa;


import br.ufc.qxd.persistencia.dao.FuncionarioLimpezaDAO;
import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.model.FuncionarioLimpeza;

public class FuncionarioLimpezaJPADAO extends GenericJpaDao<FuncionarioLimpeza> implements FuncionarioLimpezaDAO{

	public FuncionarioLimpezaJPADAO() {
		super(FuncionarioLimpeza.class);
		
	}

}
