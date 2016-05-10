package zab.awt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zab.awt.dao.StudentDAO;

public class StudentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("students", new StudentDAO().getAllStudents());
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	
	
}
