package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



public class OnlineMsgListener implements HttpSessionListener,HttpSessionAttributeListener  {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("回话建立");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		String name=(String)arg0.getSession().getAttribute("name");
		if(name!=null) {
	        ServletContext application = arg0.getSession().getServletContext();
	        String sex=(String)arg0.getSession().getAttribute("sex");
	        if(sex.equals("male")) {
	        	Integer count = (Integer) application.getAttribute("maleCount");
	        	int i = count.intValue();
	            count = i-1;
	            application.setAttribute("maleCount", count);
	        }else {
	        	Integer count = (Integer) application.getAttribute("femaleCount");
	            int i = count.intValue();
	            count = i-1;
	            application.setAttribute("femaleCount", count);
	        }
        }
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		String sex=(String)arg0.getSession().getAttribute("sex");
		if(sex!=null) {
			ServletContext application=arg0.getSession().getServletContext();
			Integer malecount=(Integer)application.getAttribute("maleCount");
			Integer femalecount=(Integer)application.getAttribute("femaleCount");
			if(sex.equals("male")) {
				if (malecount == null) {
					malecount = 1;
		        } else {
		            // +1
		            int i = malecount.intValue();
		            malecount = i+1;
		        }
		        // 改变人数
				application.setAttribute("maleCount", malecount);
			}else {
				if (femalecount == null) {
					femalecount = 1;
		        } else {
		            // +1
		            int i = femalecount.intValue();
		            femalecount = i+1;
		        }
		        // 改变人数
				application.setAttribute("femaleCount", femalecount);
			}
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
