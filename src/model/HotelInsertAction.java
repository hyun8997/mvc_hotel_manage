package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.HotelDAO;
import vo.HotelVO;

public class HotelInsertAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String ad_no = req.getParameter("ad_no");
		String h_name = req.getParameter("hn");
		String loc = req.getParameter("loc");
		String h_conv = req.getParameter("conv");
		String h_comment = req.getParameter("comment");
		
//		System.out.println(ad_no);
//		System.out.println(h_name);
//		System.out.println(loc);
//		System.out.println(h_conv);
//		System.out.println(h_comment);
		
		HotelVO vo = new HotelVO();
		vo.setAd_no(Integer.parseInt(ad_no));
		vo.setH_name(h_name);
		vo.setLoc(loc);
		vo.setH_conv(h_conv);
		vo.setH_comment(h_comment);
		
		HotelDAO dao = new HotelDAO();
		dao.addHotel(vo);
		
		req.setAttribute("ad_no", ad_no);
		
		return "/hotel/hotelInsertOk.jsp";
	}

}
