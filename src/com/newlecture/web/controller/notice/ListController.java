package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;
import com.newlecture.web.entity.Notice;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page =1; 
		String p_= request.getParameter("p");
		if(p_ != null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		NoticeDao noticeDao = new OracleNoticeDao();
		
		try {
			request.setAttribute("list", noticeDao.getList(page));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
		
		
	}
	
	
}
