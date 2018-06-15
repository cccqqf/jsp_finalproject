package servlet;

import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Message;
import bean.User;
import bean.forbidbean;
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

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String name=(String)request.getSession().getAttribute("name");
		String username=(String)request.getSession().getAttribute("username");
		String chatmsg=request.getParameter("msg");
		
		UserDao userDao=new UserDao();
		forbidbean forbid=userDao.queryforbid(name);
		Date forbiddate=forbid.getDate();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();   
	    cal.setTime(forbiddate);   
	    cal.add(Calendar.MINUTE, 5);// 24小时制   
	    forbiddate = cal.getTime();   
		Date nowdate=new Date();
		df.format(nowdate);
		int i = nowdate.compareTo(forbiddate);   
		System.out.println(i);
		
		if(forbid==null) {
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
		}else {
			if(i<=0) {
				out.println("您已被禁言");
			}else {
				//remove
				UserDao userdao=new UserDao();
				boolean result=userDao.removeForbidden(name);
				//notify
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
		out.flush();
		out.close();
	}
}



