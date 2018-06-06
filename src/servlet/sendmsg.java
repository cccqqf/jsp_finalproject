package servlet;

import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Message;
import bean.User;
import dao.HismsgDao;
import dao.UserDao;

/**
 * Servlet implementation class sendmsg
 */
@WebServlet("/sendmsg")
public class sendmsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendmsg() {
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
		
		String name=(String)request.getSession().getAttribute("name");
		String username=(String)request.getSession().getAttribute("username");
		String chatmsg=request.getParameter("msg");
		
		Message message=new Message(username,chatmsg);
		HismsgDao hismsgDao=new HismsgDao();
		hismsgDao.create(message);
		Set<String> names=getmsgservlet.waitList.keySet();
		Iterator<String> nameIt=names.iterator();
		while(nameIt.hasNext()) {
			String nameid=nameIt.next();
			Message msg=getmsgservlet.waitList.get(nameid);
			nameIt.remove();
			msg.setSay(chatmsg);
			msg.setName(name);
			
			synchronized (msg){
				msg.notifyAll();
			}
		}
	}

}
