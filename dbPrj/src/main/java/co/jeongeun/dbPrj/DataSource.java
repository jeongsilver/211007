package co.jeongeun.dbPrj;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private String driver; //사용할 jdbc 드라이버
	private String url;   //DBMS가 위치한 주소 
	private String user;  //DB에 접속할 계정
	private String password; //DB 접속계정의 패스워드 
	
	public Connection conn; //자바 연결객체
	
	public DataSource() {
		getDbproperties(); //외부 properties 파일을 읽어서 내부 변수에 담음
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password); //인터페이스 객체 .드라이버를 통해 연결해야함 그게 드라이버매니저야 드라이버를 통해 컨넥션 할게요
			System.out.println("DB 연결 성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}
	
	private void getDbproperties() {
		File path = new File("src/main/resources/db.properties"); //파일을 다루는 객체
		Properties properties = new Properties();
		try {
			FileReader file = new FileReader(path);
			properties.load(file);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(IOException e) {//입출력 예외, 모르면 그냥 Excepiton을 써
			e.printStackTrace();
		}
	}
}
