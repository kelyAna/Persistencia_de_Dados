package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.PesquisadorProjetoCassandraDAO;
import br.ufc.qxd.persistencia.model.PesquisadorProjeto;


public class PesquisadorProjetoDAO implements PesquisadorProjetoCassandraDAO{
	
	private CqlSession session;
	
	public PesquisadorProjetoDAO() {
		this.session = CassandraUtil.getSession();
	}
	
	public void insert(PesquisadorProjeto pp) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO pesquisadorProjeto "
				+ "(id, horastrabalhadas, idpesquisador, idprojeto) "
				+ "VALUES (?, ?, ?, ?);");
		BoundStatement bound = stmt.bind(pp.getId(), pp.getHorasTrabalhadas(),
				 pp.getIdPesquisador(), pp.getIdProjeto());
		session.execute(bound);
	}

	// id | horastrab | idpesquisador | idprojeto
	
	public void close() {
		CassandraUtil.closeSession();
	}



	@Override
	public void delete(PesquisadorProjeto pp) {
		delete(pp.getId());
		
	}


	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM pesquisadorProjeto WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
		
	}


	@Override
	public PesquisadorProjeto find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM pesquisadorProjeto"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		PesquisadorProjeto pp = PesquisadorProjeto.fromRow(row);
	
		return pp;
	}


	@Override
	public List<PesquisadorProjeto> findAll() {
		List<PesquisadorProjeto> pp = new ArrayList<PesquisadorProjeto>();
		String cql = "SELECT * FROM pesquisadorProjeto;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			pp.add(PesquisadorProjeto.fromRow(row));
		}
		return pp;
	}

}
