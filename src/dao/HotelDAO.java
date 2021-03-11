package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.HotelVO;

public class HotelDAO {
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;

	int h_no;
	int ad_no;
	String h_name;
	String loc;
	String h_conv;
	String h_comment;
	
	public HotelDAO() {
		conn = OracleXEConnection.getInstance().getConnection();
	}
	
	//호텔 추가
	public void addHotel(HotelVO vo) {
		sb.setLength(0);
	    sb.append("insert into hotel ");
	    sb.append("values (hotel_seq.nextval, ?, ?, ?, ?, ?) ");
	    
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, vo.getAd_no());
			pstmt.setNString(2, vo.getH_name());
			pstmt.setNString(3, vo.getLoc());
			pstmt.setNString(4, vo.getH_conv());
			pstmt.setNString(5, vo.getH_comment());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//addHotel() end
	
	//호텔 데이터 불러오기
	public HotelVO getHotel(int h_no) {
		sb.setLength(0);
	    sb.append("select * from hotel ");
	    sb.append("where h_no = ? ");
	    
	    HotelVO vo = null;
	    
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, h_no);
			
			rs = pstmt.executeQuery();

	        rs.next();
	        
	        h_no=rs.getInt("h_no");
        	ad_no=rs.getInt("ad_no");
        	h_name=rs.getNString("h_name");
        	loc=rs.getNString("loc");
        	h_conv=rs.getNString("h_conv");
        	h_comment=rs.getNString("h_comment");
        	
        	vo = new HotelVO(h_no, ad_no, h_name, loc, h_conv, h_comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return vo;
	}
	
	//호텔 정보 수정
	public void modifyHotel(String h_conv, String h_comment, int h_no) {
		sb.setLength(0);
        sb.append("update hotel ");
        sb.append("set h_conv = ?, h_comment = ? ");
        sb.append("where h_no = ? ");
        
        try {
			pstmt = conn.prepareStatement(sb.toString());
			
            pstmt.setNString(1,  h_conv);
            pstmt.setNString(2,  h_comment);
            pstmt.setInt(3, h_no);
            
            pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//호텔 삭제
	public void deleteHotel(int h_no) {
        sb.setLength(0);
        sb.append("delete hotel " );
        sb.append("where h_no = ? ");
        
        try {
           pstmt = conn.prepareStatement(sb.toString());
           pstmt.setInt(1, h_no);
           
           pstmt.executeUpdate();
           
        } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
    }
	
	//호텔 리스트 불러오기(전체)
	public ArrayList<HotelVO> getAllHotel(int startNo, int endNo){
		ArrayList<HotelVO> list = new ArrayList<HotelVO>();
		
		sb.setLength(0);
	    sb.append("select * ");
	    sb.append("from (select rownum rn, h_no, ad_no, h_name, loc, h_conv, h_comment ");
	    sb.append("from (select * from hotel ");
	    sb.append("order by h_no desc ) ");
	    sb.append("where rownum <= ? ) ");
	    sb.append("where rn >= ? ");
		
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1,  endNo);
	        pstmt.setInt(2,  startNo);
	         
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()){
	        	h_no=rs.getInt("h_no");
	        	ad_no=rs.getInt("ad_no");
	        	h_name=rs.getNString("h_name");
	        	loc=rs.getNString("loc");
	        	h_conv=rs.getNString("h_conv");
	        	h_comment=rs.getNString("h_comment");
	        	
	        	HotelVO vo = new HotelVO(h_no, ad_no, h_name, loc, h_conv, h_comment);
	        	
	        	list.add(vo);
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;
	}//getAllHotel() end
	
	//전체 호텔 갯수
	public int getTotalCount() {
		sb.setLength(0);
	    sb.append("select count(*) ");
	    sb.append("from board ");
	    int cnt = 0;
	    
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
	         
	        rs.next();
	         
	        cnt = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return cnt;
	}
	
	//호텔 리스트 불러오기(관리자 번호)
	public ArrayList<HotelVO> getAllHotel(int startNo, int endNo, int ad_no){
		ArrayList<HotelVO> list = new ArrayList<HotelVO>();
		
		sb.setLength(0);
	    sb.append("select * ");
	    sb.append("from (select rownum rn, h_no, ad_no, h_name, loc, h_conv, h_comment ");
	    sb.append("from (select * from hotel ");
	    sb.append("where ad_no = ? order by h_no desc ) ");
	    sb.append("where rownum <= ? ) ");
	    sb.append("where rn >= ? ");
		
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, ad_no);
			pstmt.setInt(2,  endNo);
	        pstmt.setInt(3,  startNo);
	         
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()){
	        	h_no=rs.getInt("h_no");
	        	//ad_no=rs.getInt("ad_no");
	        	h_name=rs.getNString("h_name");
	        	loc=rs.getNString("loc");
	        	h_conv=rs.getNString("h_conv");
	        	h_comment=rs.getNString("h_comment");
	        	
	        	HotelVO vo = new HotelVO(h_no, ad_no, h_name, loc, h_conv, h_comment);
	        	
	        	list.add(vo);
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;
	
	}
	
	//관리자의 호텔갯수
	public int getTotalCount(int ad_no) {
		sb.setLength(0);
	    sb.append("select count(*) ");
	    sb.append("from hotel ");
	    sb.append("where ad_no = ? ");
	    int cnt = 0;
	    
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, ad_no);
			
			rs = pstmt.executeQuery();
	         
	        rs.next();
	         
	        cnt = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return cnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
