package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.OracleXEConnection;
import vo.AdminVO;

public class AdminDAO {
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;

	int ad_no;
	String ad_id;
	String ad_password;
	String ad_name;
	String ad_email;
	String ad_tel;
	int ad_rank;
	
	public AdminDAO() {
		conn = OracleXEConnection.getInstance().getConnection();
	}
	
	//호텔 추가
	public void addAdmin(AdminVO vo) {
			sb.setLength(0);
		    sb.append("insert into admin ");
		    sb.append("values (admin_seq.nextval, ?, ?, ?, ?, ?, ? ) ");
		    
		   try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setNString(1, vo.getAd_id());
			pstmt.setNString(2, vo.getAd_password());
			pstmt.setNString(3, vo.getAd_name());
			pstmt.setNString(4, vo.getAd_email());
			pstmt.setNString(5, vo.getAd_tel());
			pstmt.setInt(6, vo.getAd_rank());
				
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//addAdmin() end
	
	//아이디 확인	1호텔관리자  2일반 회원
	public int[] confirmAdmin(String id, String pw) {
		sb.setLength(0);
		sb.append("select * from admin ");
		sb.append("where ad_id = ? and ad_password = ? ");
		
		int[] result = new int[2];
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setNString(1, id);
			pstmt.setNString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ad_rank = rs.getInt("ad_rank");
				result[1] = rs.getInt("ad_no");
				
				if(ad_rank == 1) {	//호텔관리자
					result[0] = 1;
				}else if(ad_rank == 2) {	//일반 회원
					result[0] = 2;
				} else {
					result[0] = 0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
