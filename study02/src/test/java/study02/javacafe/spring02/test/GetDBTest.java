package study02.javacafe.spring02.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import study.javacafe.spring02.dao.HelloDao;

public class GetDBTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		HelloDao hellodao = context.getBean("helloDao", HelloDao.class);

		assertEquals("Hello Spring!!!", hellodao.get("first").getValue());
	}

}
