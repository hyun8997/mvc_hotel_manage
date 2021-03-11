package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.HotelDAO;

public class HotelDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String ad_no = req.getParameter("ad_no");
		String no = req.getParameter("h_no");
		
		HotelDAO dao = new HotelDAO();
		int h_no = Integer.parseInt(no);
		dao.deleteHotel(h_no);
		
		req.setAttribute("ad_no", ad_no);
		
		return "/hotel/hotelDeleteOk.jsp";
	}
	
}
