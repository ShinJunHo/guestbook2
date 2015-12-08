package com.hanains.guestbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.guestbook.http.action.GuestBookActionFactory;
import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		ActionFactory actionFactory = new GuestBookActionFactory();
		
		String actionName = request.getParameter("a");
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);
		
		
		/*
		if("add".equals(actionName)){
			String name=request.getParameter("name");
			String password=request.getParameter("pass");
			String message=request.getParameter("content");
			
			GuestBookVo vo = new GuestBookVo();
			
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			GuestBookDao dao = new GuestBookDao();
			dao.insert(vo);
			response.sendRedirect("/guestbook2/gb");
		}else if("deleteform".equals(actionName)){
			HttpUtil.forwarding(request,response,"/WEB-INF/views/deleteform.jsp");
		}else if("delete".equals(actionName)){
			String no=request.getParameter("id");
			String password = request.getParameter("password");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(Long.parseLong(no));
			vo.setPassword(password);
			
			GuestBookDao dao = new GuestBookDao();
			dao.delete(vo);
			response.sendRedirect("/guestbook2/gb");
		
		}else{
			//index default action.
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.getList();
			
			// request에 담고 보내는 거니깐.
			request.setAttribute("list", list);
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request,response);

			
			
		}*/
	}
}
