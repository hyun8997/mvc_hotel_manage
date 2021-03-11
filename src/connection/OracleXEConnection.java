package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleXEConnection {
	private static OracleXEConnection oc = null;
	private static Connection conn;
	
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USER = "scott";
	final String PASSWORD = "tiger";
	
	private OracleXEConnection() {}
	
	public static OracleXEConnection getInstance() {
		if(oc == null) oc = new OracleXEConnection();	//기본 연결 상태가 null이면 생성자 실행해주고 리턴
		return oc;
	}
	
	public Connection getConnection() {		//Connection 없을 때 연결하고 리턴
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				System.out.println("conn : "+conn);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("드라이버 로팅 실패");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("DBMS 연결 실패");
			}
		}//if end
		return conn;
	}
	
}
