package study.javacafe.spring02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import study.javacafe.spring02.domain.Hello;

public class HelloDao {
	private ConnectionMaker connectionMaker;
	
	public void setConnectionMaker(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}

	public Hello get(String key) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();
		
		PreparedStatement ps = c
				.prepareStatement("select value from likemap where name = ?");
		ps.setString(1, key);

		ResultSet rs = ps.executeQuery();
		rs.next();
		
		Hello hello = new Hello();
		hello.setValue(rs.getString("value"));

		rs.close();
		ps.close();
		c.close();

		return hello;
	}
}
