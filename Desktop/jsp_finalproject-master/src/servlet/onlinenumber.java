package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class onlinenumber
 */
@WebServlet("/onlinenumber")
public class onlinenumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onlinenumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		
		int malecount=0;
		int femalecount=0;
		if(request.getServletContext().getAttribute("maleCount")!=null){
			malecount=(int)request.getServletContext().getAttribute("maleCount"); 
		}
		if(request.getServletContext().getAttribute("femaleCount")!=null){
			femalecount=(int)request.getServletContext().getAttribute("femaleCount");
		}
		out.print("<p id=\"malecount\">"+malecount+"</p><p id=\"femalecount\">"+femalecount+"</p>");
	}

}
