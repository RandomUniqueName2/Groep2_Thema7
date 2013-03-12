package dao;

import java.sql.Connection;

public interface IBusinessRuleDAO {
	public void create(Connection connection);
	public void read();
	public void update();
	public void delete();
}
