package com.login;

import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Login  {
	
	
	public String doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
	
	//Taking user input.
		String username=req.getParameter("username");
		String password=req.getParameter("password");
	// Checking for session
		if(req.getSession().getAttribute("user")==null){
			System.out.println("new Seesion");
			//Checking user input.
			if(username==""||password==""||username==null||password==null){
				System.out.println("null value");
				req.getSession().setAttribute("error", "Login Failed");
				return "index";
				
			}
			
			else {
				PersistenceManager pm = PMF.getPMF().getPersistenceManager();
				try{
				UserDetail ud= pm.getObjectById(UserDetail.class, username);
				if(username.equals(ud.getUsername())&& password.equals(ud.getPassword())){
				System.out.println("value for req  "+req.getParameter("username"));
				long count=ud.getLoginCount();
				count++;
				ud.setLoginCount(count);
				req.getSession().setAttribute("user", ud.getName());
				req.getSession().setAttribute("email", ud.getUsername());
				req.getSession().setAttribute("pass", ud.getPassword());
				req.getSession().setAttribute("dob", ud.getDob());
				req.getSession().setAttribute("cont", ud.getContact());
				req.getSession().setAttribute("city", ud.getCity());
				req.getSession().setAttribute("loginCount", ud.getLoginCount());
				req.getSession().setAttribute("prof_pic", "http://springbyhrishabh.appspot.com/serve?blobkey="+ud.getPic());
				
				return "welcome";
				}
			else{
				req.getSession().setAttribute("error", "Login Failed");
				return "index";
			}
				}
			catch(Exception e){
				req.getSession().setAttribute("error", "Login Failed");
				return "index";
			}
			}
		}
		else{
			
			System.out.println("old Seesion");
			
			System.out.println(req.getSession().getAttribute("user"));
			return "welcome";
			
		}
		
	}
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		return doPost(req, resp);
	}
	
	public String logout(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.getSession().invalidate();
		return "index";
	}
	
}
