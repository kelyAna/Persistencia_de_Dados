package br.ufc.qxd.persistencia.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import br.ufc.qxd.persistencia.Cassandra.CassandraUtil;
import br.ufc.qxd.persistencia.dao.PesquisadorCassandraDAO;
import br.ufc.qxd.persistencia.model.Dependente;
import br.ufc.qxd.persistencia.model.Pesquisador;

public class PesquisadorDAO implements PesquisadorCassandraDAO{

	private CqlSession session;
	
	
	
	public PesquisadorDAO() {
		this.session = CassandraUtil.getSession();

	}

	@Override
	public void insert(Pesquisador p) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO pesquisador "
				+ "(id, areaatuacao,dataaniversario,endereco,nome,salario,sexo) "
				+ "VALUES (?,?,?,?,?,?,?);");
		BoundStatement bound = stmt.bind(p.getId(),p.getAreaAtuacao(),p.getDataAniversario(),p.getEndereco()
				,p.getNome(),p.getSalario(),p.getSexo());
		session.execute(bound);
		
	}
	

	
	@Override
	public void delete(Pesquisador p) {
		delete(p.getId());
	}

	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM pesquisador WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}

	@Override
	public Pesquisador find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM pesquisador"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		Pesquisador p = Pesquisador.fromRow(row);
		
		return p;
	}

	@Override
	public List<Pesquisador> findAll() {
		List<Pesquisador> pesquisador = new ArrayList<Pesquisador>();
		String cql = "SELECT * FROM pesquisador;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			pesquisador.add(Pesquisador.fromRow(row));
		}
		return pesquisador;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();
	}

}
