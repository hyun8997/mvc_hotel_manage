package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class MainAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "/hotel/hotelMain.jsp";
	}
	
}
