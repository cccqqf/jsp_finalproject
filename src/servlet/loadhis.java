package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.HismsgDao;

/**
 * Servlet implementation class loadhis
 */
@WebServlet("/loadhis")
public class loadhis extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadhis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
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
		
		Queue<Message> msgqueue=new LinkedList<Message>();   

		String name=(String)request.getSession().getAttribute("name");
		Message message=new Message();
		HismsgDao hismsgDao=new HismsgDao();
		hismsgDao.loadhismsg(msgqueue);
		while(!(msgqueue.isEmpty())) {
			message=msgqueue.poll();
			String messagename=message.getName();
			if(messagename.equals(name)) {
				out.print("<div style=\"text-align:right\"><div id=\"box_right\">"+message.getSay()+"</div>"+message.getName()+"</div>");
			}else {
				out.print("<div><a  onclick=\"showdiv(this.name)\" id=\"forbid\" name=\""+message.getName()+"\">"+message.getName()+"</a><div id=\"box_left\">"+message.getSay()+"</div></div>");
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		out.print("<div class=\"line\">"+df.format(new Date())+"</div>");
		out.flush();
		out.close();
	}

}
