package project01_common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	//Oracle DB 정보
	private String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	private String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId = "project01";
	private String connectedPwd = "project01";
	
	//공통으로 사용되는 필드
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DAO() {
		//dbConfig();		//미리 접속해도됨. 커넥트메소드 안에들어가도되고
	}
	
	//DB에 접속 메소드
	/*private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		try {
			String filePath
			= ClassLoader.getSystemClassLoader()
			.getResource(resource)
			.getPath();
		properties.load(new FileInputStream(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}*/
	
	//DB 정보 가져오는 메소드
	public void connect() {
		try {
			Class.forName(jdbcDriver);
			
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		}catch(ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		}catch(SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
	}
	
	//DB 접속 해제 메소드
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
