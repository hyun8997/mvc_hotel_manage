package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.HotelDAO;
import vo.HotelVO;

public class HotelDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String h_no = req.getParameter("h_no");
		String ad_no = req.getParameter("ad_no");
		
		//System.out.println(ad_no);
		//System.out.println(h_no);
		
		if(h_no != null) {
			HotelVO vo = new HotelVO();
			HotelDAO dao = new HotelDAO();
			
			int hno = Integer.parseInt(h_no);
			
			vo = dao.getHotel(hno);
			
			req.setAttribute("vo", vo);
			
			return "/hotel/hotelDetail.jsp";
			
		}else {
			return "./hotel.do?cmd=hotelList&ad_no="+ad_no;
		}
	}

}
