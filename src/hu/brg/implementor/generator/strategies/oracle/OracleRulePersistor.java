package hu.brg.implementor.generator.strategies.oracle;

import hu.brg.implementor.generator.RulePersistor;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class OracleRulePersistor extends RulePersistor {

	@Override
	public void connect(String connectString, String username, String password)
			throws SQLException {
		OracleDataSource ds = new OracleDataSource();
		ds.setURL("jdbc:oracle:thin:@" + connectString);
		ds.setUser(username);
		ds.setPassword(password);
		
		conn = ds.getConnection();
	}

}
