package hu.brg.implementor.generator;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class RulePersistor implements iRulePersistor {
	protected Connection conn = null;
	

	@Override
	public void runStatement(String sql) throws Exception, SQLException {
		if (conn != null) {
			this.conn.createStatement().executeQuery(sql);
		} else {
			throw new Exception("Cannot execute query. No connection to the database is established");
		}
	}

	@Override
	public abstract void connect(String connectString, String username, String password) throws SQLException;
	
	@Override
	public void close() throws SQLException {
		this.conn.close();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return this.conn.isClosed();
	}
	
	@Override
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
