package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.DependenteCassandraDAO;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.Dependente;

public class DependenteDAO implements DependenteCassandraDAO{
	
	private CqlSession session;
	

	public DependenteDAO() {
		
		this.session = CassandraUtil.getSession();
	}



	@Override
	public void insert(Dependente depe) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO dependente "
				+ "(id, dataaniversario, grauparentesco, idfuncionario,nome, sexo) "
				+ "VALUES (?, ?, ?, ?, ?, ?);");
		BoundStatement bound = stmt.bind(depe.getId(),depe.getDataAniver(),
				depe.getGrauParentesco(),depe.getIdFuncionario(),
				depe.getNome(),depe.getSexo());
		session.execute(bound);
	}



	@Override
	public void delete(Dependente depe) {
		delete(depe.getId());
		
	}

	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM dependente WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}

	@Override
	public Dependente find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM dependente"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		Dependente depe = Dependente.fromRow(row);
		return depe;
	}

	@Override
	public List<Dependente> findAll() {
		List<Dependente> dependente = new ArrayList<Dependente>();
		String cql = "SELECT * FROM dependente;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			dependente.add(Dependente.fromRow(row));
		}
		return dependente;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();
	}
	
}
