package study.javacafe.spring02;

import java.sql.SQLException;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import study.javacafe.spring02.dao.HelloDao;

@Controller
public class HelloContorller {
	
	@RequestMapping("/hello")
	public String hello(Locale locale, Model model) throws ClassNotFoundException, SQLException {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		HelloDao hellodao = context.getBean("helloDao", HelloDao.class);
		
		model.addAttribute("first", hellodao.get("first").getValue());
		
		return "helloSpring";		
	}
	
}
