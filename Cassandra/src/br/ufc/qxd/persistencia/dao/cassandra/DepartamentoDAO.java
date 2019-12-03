package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.DepartamentoCassandraDAO;
import br.ufc.qxd.persistencia.model.Departamento;

public class DepartamentoDAO implements DepartamentoCassandraDAO{

	
	private CqlSession session;

	
	public DepartamentoDAO() {
		
		this.session = CassandraUtil.getSession();

	}

	@Override
	public void insert(Departamento dep) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO departamento "
				+ "(id, nome) "
				+ "VALUES (?, ?);");
		BoundStatement bound = stmt.bind(dep.getId(),dep.getNome());
		session.execute(bound);
	}

	@Override
	public void delete(Departamento dep) {
		delete(dep.getId());
		
	}

	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM departamento WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}

	@Override
	public Departamento find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM departamento"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		Departamento dep = Departamento.fromRow(row);
		return dep;
	}

	@Override
	public List<Departamento> findAll() {
		List<Departamento> dep = new ArrayList<Departamento>();
		String cql = "SELECT * FROM departamento;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			dep.add(Departamento.fromRow(row));
		}
		return dep;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();
	}
		
}
