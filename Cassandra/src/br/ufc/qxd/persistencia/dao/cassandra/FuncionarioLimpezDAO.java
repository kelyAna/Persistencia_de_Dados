package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.FuncionarioLimpezaCassandraDAO;
import br.ufc.qxd.persistencia.model.FuncionarioLimpeza;

public class FuncionarioLimpezDAO implements FuncionarioLimpezaCassandraDAO{
	
private CqlSession session;
		
	
	public FuncionarioLimpezDAO() {

		this.session = CassandraUtil.getSession();

	}

	@Override
	public void insert(FuncionarioLimpeza fl) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO funcionarioLimpeza "
				+ "(id,cargo,codgerente,dataaniversario,endereco,jornadatrabalho,nome,salario,sexo)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
		BoundStatement bound = stmt.bind(fl.getId(),fl.getCargo(),fl.getCodGerente(),fl.getDataAniversario(),fl.getEndereco(),fl.getJornadaTrabalho(),fl.getNome(),fl.getSalario(),fl.getSexo());
		session.execute(bound);
	}

	@Override
	public void delete(FuncionarioLimpeza fl) {
		delete(fl.getId());
		
	}


	@Override
	public FuncionarioLimpeza find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM funcionarioLimpeza"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		FuncionarioLimpeza fl = FuncionarioLimpeza.fromRow(row);
		
		return fl;
	}

	@Override
	public List<FuncionarioLimpeza> findAll() {
		List<FuncionarioLimpeza> fl = new ArrayList<FuncionarioLimpeza>();
		String cql = "SELECT * FROM funcionarioLimpeza;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			fl.add(FuncionarioLimpeza.fromRow(row));
		}
		return fl;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();
	}


	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM funcionarioLimpeza WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}


}
