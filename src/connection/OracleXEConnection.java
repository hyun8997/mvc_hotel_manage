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
		if(oc == null) oc = new OracleXEConnection();	//�⺻ ���� ���°� null�̸� ������ �������ְ� ����
		return oc;
	}
	
	public Connection getConnection() {		//Connection ���� �� �����ϰ� ����
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				System.out.println("conn : "+conn);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("����̹� ���� ����");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("DBMS ���� ����");
			}
		}//if end
		return conn;
	}
	
}
