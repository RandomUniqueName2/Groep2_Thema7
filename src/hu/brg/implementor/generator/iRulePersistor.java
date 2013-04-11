package hu.brg.implementor.generator;

import java.sql.SQLException;

public interface iRulePersistor {

	public abstract void runStatement(String sql) throws Exception,
			SQLException;

	public abstract void connect(String connectString, String username,
			String password) throws SQLException;

	public abstract void close() throws SQLException;

	public abstract boolean isClosed() throws SQLException;

	public abstract Boolean isConnected();

}