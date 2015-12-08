package com.hanains.guestbook.http.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;
import com.hanains.http.action.Action;

public class IndexAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	GuestBookDao dao = new GuestBookDao();
	List<GuestBookVo> list = dao.getList();
	
	// request에 담고 보내는 거니깐.
	request.setAttribute("list", list);
	//forwarding
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
	rd.forward(request,response);

}
}
