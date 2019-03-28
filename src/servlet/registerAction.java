package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class registerAction
 */
@WebServlet("/registerAction")
public class registerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerAction() {
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
		
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("regname");
		String username=request.getParameter("regusername");
		String password=request.getParameter("regpassword");
		String sex=request.getParameter("sex");
		
		UserDao userDao=new UserDao();
		User isregister=userDao.query(username);
		if(isregister!=null) {
			out.println("<script>alert('用户名已存在');location='login.jsp';</script>");
		}else {
			if(sex.equals("choose")) {
				out.println("<script>alert('请选择性别');location='login.jsp';</script>");
			}else {
				User user=new User(name,username,password,sex);
				boolean result = userDao.create(user);
				if(result==true) {
					out.println("<script>alert('注册成功');location='login.jsp';</script>");
				}
			}
		}
		out.flush();
		out.close();
	}

}
