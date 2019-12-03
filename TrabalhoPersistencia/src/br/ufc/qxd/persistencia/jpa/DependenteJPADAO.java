package br.ufc.qxd.persistencia.jpa;


import br.ufc.qxd.persistencia.dao.DependenteDAO;
import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.model.Dependente;

public class DependenteJPADAO extends GenericJpaDao<Dependente> implements DependenteDAO{

	public DependenteJPADAO() {
		super(Dependente.class);
		
	}

}
