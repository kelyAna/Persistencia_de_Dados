package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.ProjetoCassandraDAO;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.Projeto;

public class ProjetoDAO implements ProjetoCassandraDAO{
	
	private CqlSession session;

	
	public ProjetoDAO() {
		this.session = CassandraUtil.getSession();

	}

	@Override
	public void insert(Projeto proj) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO projeto "
				+ "(id, iddepartamento, nome, periodo) "
				+ "VALUES (?, ?, ?, ?);");
		BoundStatement bound = stmt.bind(proj.getId(),proj.getIdDepartamento(), proj.getNome(),proj.getPeriodo());
		session.execute(bound);
	}

	@Override
	public void delete(Projeto proj) {
		delete(proj.getId());

	}

	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM projeto WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}

	@Override
	public Projeto find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM projeto"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		Projeto proj = Projeto.fromRow(row);
		
		return proj;	
		
	}

	@Override
	public List<Projeto> findAll() {
		List<Projeto> proj = new ArrayList<Projeto>();
		String cql = "SELECT * FROM projeto;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			proj.add(Projeto.fromRow(row));
		}
		return proj;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();

	}

	
}
