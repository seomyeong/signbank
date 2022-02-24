package signBanking.data;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeDataSource implements ServletContextListener {
	/*
	 * contextInitialized : 시작될 때 톰캣이 부르는 메소드. 그래서 여기에 DB초기화작업을 연결.
	 * ServletContext을 얻어와서 setInitPrameter메소드에 경로를 연결해주면, 
	 * context.getInitParameter("jdbc-properties"); : 파일을 객체화시킨다.
	 */
	public void contextInitialized(ServletContextEvent event)  { 
		ServletContext context = event.getServletContext();
		context.setInitParameter("jdbc-properties", "/WEB-INF/data/jdbc.properties");
		String jdbcFilePath = context.getInitParameter("jdbc-properties"); //파일을 불러온다.
		
		InputStream is = null;
		try {
			is = context.getResourceAsStream(jdbcFilePath); //props.load는 stream을 필요하기 때문에, getResourceAsStream에 path를 넣으면 inputStream으로 반환해준다.
			Properties props = new Properties();
			props.load(is);
			
			String jdbcDriver = props.getProperty("jdbcDriver");
			String jdbcUrl = props.getProperty("jdbcUrl");
			String userName = props.getProperty("jdbcUser");
			String password = props.getProperty("jdbcPassword");
			
			DataSource ds = DataSource.getInstance();
			ds.initDataSource(jdbcDriver, jdbcUrl, userName, password);
			System.out.println("InitializeDataSource is initialized..");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * contextDestroyed : 종료 시 호출되는 메소드
	 */
	public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("애플리케이션 종료");
    }

	
}
