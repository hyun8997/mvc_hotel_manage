package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.AdminDAO;
import vo.AdminVO;

public class LoginOkAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//System.out.println(id+" "+pw);
		
		if(id!=null && pw!=null) {
			AdminVO vo = new AdminVO();
			AdminDAO dao = new AdminDAO();
			
			int[] result = new int[2];
			
			result = dao.confirmAdmin(id, pw);
			
			if(result[0] == 1) {
				//호텔 관리자
				//System.out.println(result[0]+" "+result[1]);
				return "/hotel/hotel.do?cmd=hotelList&ad_no="+String.valueOf(result[1]);
			}
			
//			else if(result[0] == 2) {
//				//일반 회원
//				//일단 무시
//			}
			
			else {
				return "/hotel/hotelMain.jsp";
			}
		}else {
			return "/hotel/hotelMain.jsp";
		}
	}

}
