package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.HotelDeleteAction;
import model.HotelDetailAction;
import model.HotelInsertAction;
import model.HotelInsertFormAction;
import model.HotelListAction;
import model.HotelModifyAction;
import model.HotelModifyOkAction;
import model.LoginFormAction;
import model.LoginOkAction;
import model.MainAction;

@WebServlet("/hotel/hotel.do")
public class HotelControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String cmd = req.getParameter("cmd");
		String viewPage = null;
		Action model = null;
		
		if(cmd==null || cmd.equalsIgnoreCase("main")) {
			//전체 리스트 페이지
			model = new MainAction();
		}else if(cmd.equalsIgnoreCase("loginForm")) {
			//login  form 페이지
			model = new LoginFormAction();
		}else if(cmd.equalsIgnoreCase("loginOk")) {
			//loginOk
			model = new LoginOkAction();
		}else if(cmd.equalsIgnoreCase("hotelList")) {
			//hotel list
			model = new HotelListAction();
		}else if(cmd.equalsIgnoreCase("hotelInsertForm")) {
			//hotel insert form
			model = new HotelInsertFormAction();
		}else if(cmd.equalsIgnoreCase("hotelInsert")) {
			//hotel insert
			model = new HotelInsertAction();
		}else if(cmd.equalsIgnoreCase("hotelDetail")) {
			//hotel detail
			model = new HotelDetailAction();
		}else if(cmd.equalsIgnoreCase("hotelModify")) {
			//hotel detail
			model = new HotelModifyAction();
		}else if(cmd.equalsIgnoreCase("hotelModifyOk")) {
			//hotel detail
			model = new HotelModifyOkAction();
		}else if(cmd.equalsIgnoreCase("hotelDelete")) {
			//hotel detail
			model = new HotelDeleteAction();
		}
		
		viewPage = model.execute(req, resp);
		
		//페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//doProcess() end
	
}
