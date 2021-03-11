package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.HotelVO;
import vo.RoomOfHotelVO;

public class RoomOfHotelDAO {
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	int r_no;
	int h_no;
	String r_name;
	int maxppl;
	int price;
	
	public RoomOfHotelDAO() {
		conn = OracleXEConnection.getInstance().getConnection();
	}
	
	//방 추가
	public void addRoom(RoomOfHotelVO vo) {
		sb.setLength(0);
	    sb.append("insert into roomofhotel ");
	    sb.append("values (room_seq.nextval, ?, ?, ?, ? ) ");
	    
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, vo.getH_no());
			pstmt.setNString(2, vo.getR_name());
			pstmt.setInt(3, vo.getMaxppl());
			pstmt.setInt(4, vo.getPrice());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//addRoom() end
	
	//방 데이터 불러오기
	public RoomOfHotelVO getRoom(int r_no) {
		sb.setLength(0);
	    sb.append("select * from roomofhotel ");
	    sb.append("where r_no = ? ");
	    
	    RoomOfHotelVO vo = null;
	    
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, r_no);
			
			rs = pstmt.executeQuery();

	        rs.next();
	        
	        r_no=rs.getInt("r_no");
	    	h_no=rs.getInt("h_no");
	    	r_name=rs.getNString("r_name");
	    	maxppl=rs.getInt("maxppl");
	    	price=rs.getInt("price");
	        
	        vo = new RoomOfHotelVO(r_no, h_no, r_name, maxppl, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return vo;
	}	
	
	//방 정보 수정
	public void modifyRoom(RoomOfHotelVO vo) {
		sb.setLength(0);
        sb.append("update roomofhotel ");
        sb.append("set r_name = ?, maxppl = ?, price = ? ");
        sb.append("where r_no = ? ");
        
        try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setNString(1, vo.getR_name());
			pstmt.setInt(2, vo.getMaxppl());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getR_no());
            
            pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	//방 삭제
	public void deleteRoom(int r_no) {
        sb.setLength(0);
        sb.append("delete roomofhotel " );
        sb.append("where r_no = ? ");
        
        try {
           pstmt = conn.prepareStatement(sb.toString());
           pstmt.setInt(1, r_no);
           
           pstmt.executeUpdate();
           
        } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
    }	
	
	
	//방 리스트 불러오기(호텔 번호)
	public ArrayList<RoomOfHotelVO> getAllRoom(int h_no){
		ArrayList<RoomOfHotelVO> list = new ArrayList<RoomOfHotelVO>();
		
		sb.setLength(0);
	    sb.append("select * from roomofhotel ");
	    sb.append("where h_no = ? ");
		
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, h_no);
	         
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()){
	        	r_no=rs.getInt("r_no");
		    	//h_no=rs.getInt("h_no");
		    	r_name=rs.getNString("r_name");
		    	maxppl=rs.getInt("maxppl");
		    	price=rs.getInt("price");
	        	
	        	RoomOfHotelVO vo = new RoomOfHotelVO(r_no, h_no, r_name, maxppl, price);
	        	
	        	list.add(vo);
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;
	
	}
	
	
	
	
	
	
	
	
	
}
