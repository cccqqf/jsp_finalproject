package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;

/**
 * Servlet implementation class getmsgservlet
 */
@WebServlet("/getmsgservlet")
public class getmsgservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static Hashtable<String,Message> waitList=new Hashtable<String,Message>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmsgservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request,response);
		
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
		
		Message msg=new Message();
		String name=(String)request.getSession().getAttribute("name");
		//String name="�����";
		waitList.put(name, msg);
		synchronized(msg) {
			try {
				msg.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		out.print(msg.getName()+":"+msg.getSay()+"<br/>");
		
		out.flush();
		out.close();
	}

}
