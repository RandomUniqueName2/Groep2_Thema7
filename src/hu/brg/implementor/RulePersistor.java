package hu.brg.implementor;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class RulePersistor {
	protected Connection conn = null;
	
	public void runStatement(String sql) throws Exception, SQLException {
		if (conn != null) {
			this.conn.createStatement().executeQuery(sql);
		} else {
			throw new Exception("Cannot execute query. No connection to the database is established");
		}
	}
	
	public abstract void connect(String connectString, String username, String password) throws SQLException;
	
	public void close() throws SQLException {
		this.conn.close();
	}

	public boolean isClosed() throws SQLException {
		return this.conn.isClosed();
	}
	
	public Boolean isConnected() {
		if (conn != null) {
			try {
				return conn.isValid(3);
			} catch (SQLException e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
