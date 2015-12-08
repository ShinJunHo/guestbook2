package com.hanains.guestbook.http.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;
import com.hanains.http.action.Action;

public class DeleteAction implements Action {
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	String no=request.getParameter("id");
	String password = request.getParameter("password");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setNo(Long.parseLong(no));
	vo.setPassword(password);
	
	GuestBookDao dao = new GuestBookDao();
	dao.delete(vo);
	response.sendRedirect("/guestbook2/gb");
}
}
