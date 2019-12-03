package br.ufc.qxd.persistencia.jpa;

import br.ufc.qxd.persistencia.dao.FuncionarioLimpezaDAO;
import br.ufc.qxd.persistencia.dao.GenericJpaDao;
import br.ufc.qxd.persistencia.dao.Pesquisador_ProjetoDAO;
import br.ufc.qxd.persistencia.model.FuncionarioLimpeza;
import br.ufc.qxd.persistencia.model.Pesquisador_Projeto;

public class Pesquisador_ProjetoJPADAO extends GenericJpaDao<Pesquisador_Projeto> implements Pesquisador_ProjetoDAO{

	public Pesquisador_ProjetoJPADAO() {
		super(Pesquisador_Projeto.class);
		
	}
	

}
