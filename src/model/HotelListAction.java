package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.HotelDAO;
import vo.HotelVO;

public class HotelListAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String cp = req.getParameter("cp");
		String ad_no = req.getParameter("ad_no");
		
		//System.out.println(ad_no);
		
		int no = Integer.parseInt(ad_no); 
		

		int currentPage = 0;
	      
		if(cp!=null){
			currentPage = Integer.parseInt(cp);
		}else{
			currentPage =1;
		}
	    		
		HotelDAO dao = new HotelDAO();
		HotelVO vo = new HotelVO();
		
		// 총 게시글 수
		int totalCount = dao.getTotalCount(no);
	    
		// 한페이지당 레코드 수 : 10 개씩 자르기
		int recordBypage = 10;
			          
		// 총 페이지 수 
		int totalPage = (totalCount%recordBypage==0)?totalCount/recordBypage:totalCount/recordBypage+1;
		
		
		// 현재 페이지 - 레코드 시작 번호
		int startNo = (currentPage-1)*recordBypage+1;
			          
		// 현재페이지 - 레코드 끝 번호
		int endNo = currentPage*recordBypage;
		
		
		
		
		ArrayList<HotelVO> list = dao.getAllHotel(startNo, endNo, no);
		
		// 요청 객체에 set
		req.setAttribute("list", list);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("ad_no", no);
		
		
		return "/hotel/hotelList.jsp";
	}

}
