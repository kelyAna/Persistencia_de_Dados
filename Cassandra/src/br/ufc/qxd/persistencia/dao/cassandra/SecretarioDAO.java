package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.SecretarioCassandraDAO;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.Secretario;

public class SecretarioDAO implements SecretarioCassandraDAO{

	private CqlSession session;
	
	
	public SecretarioDAO() {
		this.session = CassandraUtil.getSession();

	}

	@Override
	public void insert(Secretario sec) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO secretario "
				+ "(id, dataaniversario, endereco, grauescolaridade, nome, salario, sexo) "
				+ "VALUES (?,?,?,?,?,?,?);");
		BoundStatement bound = stmt.bind(sec.getId(),sec.getDataAniversario(),sec.getEndereco(),sec.getGrauEscolaridade(), sec.getNome(),sec.getSalario(),sec.getSexo());
		session.execute(bound);
	
	}

	@Override
	public void delete(Secretario sec) {
		delete(sec.getId());
		
	}

	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM secretario WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}

	@Override
	public Secretario find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM secretario"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		Secretario sec = Secretario.fromRow(row);
		
		return sec;
	}

	@Override
	public List<Secretario> findAll() {
		List<Secretario> sec = new ArrayList<Secretario>();
		String cql = "SELECT * FROM secretario;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			sec.add(Secretario.fromRow(row));
		}
		return sec;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();
	}

}
