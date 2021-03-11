package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.HotelDAO;
import vo.HotelVO;

public class HotelModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("h_no");
		String ad_no=req.getParameter("ad_no");
		//System.out.println(h_no);
		
		if(no!=null){		/* null처리 */
			HotelVO vo = new HotelVO();
			HotelDAO dao = new HotelDAO();
			
			int h_no = Integer.parseInt(no);
			
			vo=dao.getHotel(h_no);
			
			req.setAttribute("vo", vo);
			
			return "/hotel/hotelModify.jsp";
		}else {
			return "./hotel.do?cmd=hotelDetail&h_no="+no+"&ad_no="+ad_no;
		}
			
		
		
		
		
	}

}
