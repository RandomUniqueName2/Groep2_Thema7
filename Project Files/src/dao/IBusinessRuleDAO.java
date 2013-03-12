package dao;

import java.sql.Connection;

public interface IBusinessRuleDAO {
	public void create(Connection connection);
	public void read(Connection connection);
}
