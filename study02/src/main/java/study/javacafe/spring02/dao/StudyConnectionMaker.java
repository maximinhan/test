package study.javacafe.spring02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudyConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://maximinhan.iptime.org/mystudy?characterEncoding=UTF-8", "lunarcat", "rhdiddl");
		return c;
	}

}
