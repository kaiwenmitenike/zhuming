package com.sp.xmgl.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.xmgl.dao.UserDao;
import com.sp.xmgl.vo.User;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		if("login".equals(flag)){
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String isSave = request.getParameter("isSave");
			
			UserDao userDao = new UserDao();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			List<User> list = userDao.select(user);
			if(list.size()==0){
				request.setAttribute("flag", "false");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				HttpSession session = request.getSession();
				System.out.println("session id:"+session.getId());
				session.setAttribute("user", list.get(0));
				ServletContext app = session.getServletContext();
				if(app.getAttribute(username)!=null){
					HttpSession session1 = (HttpSession)app.getAttribute(username);
					if(session.getId().equals(session1.getId())){
						session1.invalidate();
					}
				}
				app.setAttribute(username, session);
				
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("isSave", isSave);
				response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
				//request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
			}
		}else if("out".equals(flag)){
			HttpSession session = request.getSession();	
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}
}
