package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class HotelInsertFormAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String ad_no = req.getParameter("ad_no");
		//System.out.println(ad_no);
		req.setAttribute("ad_no", ad_no);
		return "/hotel/hotelInsert.jsp";
	}

}
