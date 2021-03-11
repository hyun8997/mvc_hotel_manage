package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.HotelDAO;
import vo.HotelVO;

public class HotelModifyOkAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String h_conv = req.getParameter("conv");
		String h_comment = req.getParameter("comment");
		String no = req.getParameter("h_no");
		String ad_no = req.getParameter("ad_no");
		
//		System.out.println(h_conv);
//		System.out.println(h_comment);
		
		if(no!=null){
			int h_no = Integer.parseInt(no);
			
			HotelDAO dao = new HotelDAO();
			
			dao.modifyHotel(h_conv, h_comment, h_no);
			
			req.setAttribute("ad_no", ad_no);
			
			return "/hotel/hotelModifyOk.jsp";
		}else {
			return "./hotel.do?cmd=hotelDetail&h_no="+no+"&ad_no="+ad_no;
		}
		
	}

}
