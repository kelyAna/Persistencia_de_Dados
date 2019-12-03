package br.ufc.qxd.persistencia.Cassandra;

import com.datastax.oss.driver.api.core.CqlSession;

public class CassandraUtil {
	
	private final static String DATABASE = "trab"; 
	private static SimpleClient client = new SimpleClient(DATABASE);

	public static CqlSession getSession() {
		return client.getSession();
	}
	
	public static CqlSession getSession(ContactPoint... contactPoints) {
		return client.getSession(contactPoints);
	}
	
	public static void closeSession() {
		client.closeSession();
	}
}
