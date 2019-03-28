package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.SearchDao;

/**
 * Servlet implementation class searchaction
 */
@WebServlet("/searchaction")
public class searchaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchaction() {
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
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String submessage=(String)request.getParameter("content");
		Queue<Message> msgqueue=new LinkedList<Message>();
		Message message=new Message();
		SearchDao searchDao=new SearchDao();
		searchDao.Search(msgqueue, submessage);
		while(!(msgqueue.isEmpty())) {
			message=msgqueue.poll();
			out.print("<div style=\"text-align:right;margin:20px\"><div id=\"box_right\">"+message.getSay()+"</div>"+message.getName()+"</div>");
		}
		out.flush();
		out.close();
	}

}
