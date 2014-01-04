package storage;

import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.email.SendEmail;
import com.login.PMF;
import com.login.UserDetail;

public class DataStorage {
	PersistenceManager pm = PMF.getPMF().getPersistenceManager();
	HttpSession session;
	UserDetail ud=new UserDetail();
	//Adding a new user
	public String addUser(HttpServletRequest req, HttpServletResponse resp, String bkey) {
		try {
		session=req.getSession();
		if(session.getAttribute("user")!=null){
			resp.sendRedirect("/login");
		}
		else{
		ud.setUsername(req.getParameter("email"));
		ud.setPassword(req.getParameter("password"));
		ud.setName(req.getParameter("name"));
		ud.setDob(req.getParameter("dob"));
		ud.setContact(req.getParameter("contact"));
		ud.setCity(req.getParameter("city"));
		ud.setLoginCount(1);
		if(bkey!=null){
		ud.setPic(bkey);
		}
		System.out.println("dob will come");
	    pm.makePersistent(ud);
	    pm.close();
	    
	    SendEmail email=new SendEmail();
	    
			email.sendMail(ud.getUsername(), ud.getName());
			System.out.println("email sent to "+ud.getUsername());
			
			session.setAttribute("user", ud.getName());
			session.setAttribute("pass", ud.getPassword());
			session.setAttribute("dob", ud.getDob());
			session.setAttribute("cont", ud.getContact());
			session.setAttribute("email", ud.getUsername());
			session.setAttribute("loginCount", ud.getLoginCount());
			session.setAttribute("city", ud.getCity());
			session.setAttribute("prof_pic", "http://springbyhrishabh.appspot.com/serve?blobkey="+ud.getPic());
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
	    return "success";
	}
	
	//Update Data of User
	public String updateUser(HttpServletRequest req,HttpServletResponse resp, Map<String, String> map){
		try{
			session=req.getSession();
			if(session.getAttribute("user")==null){
				resp.sendRedirect("/login");
				return "error";
			}
			else{
				ud= pm.getObjectById(UserDetail.class, map.get("email"));
				ud.setPassword(map.get("password"));
				ud.setName(map.get("name"));
				ud.setDob(map.get("dob"));
				ud.setContact(map.get("contact"));
				ud.setCity(map.get("city"));
				pm.makePersistent(ud);
			    pm.close();
			    session.setAttribute("user", ud.getName());
			    session.setAttribute("pass", ud.getPassword());
			    session.setAttribute("dob", ud.getDob());
			    session.setAttribute("cont", ud.getContact());
			    session.setAttribute("city", ud.getCity());
				System.out.println("in update try");
			    return "success";
			}
		}
		catch(Exception e){
			System.out.println("in update catch" +e.toString());
			return "error";
		}
		
		
	}
	
	//Deleting data
	public void deleteUser(HttpServletRequest req){
		UserDetail ud= pm.getObjectById(UserDetail.class, req.getParameter("username"));
		req.getSession().invalidate();
		pm.deletePersistent(ud);
	}
	
	
	//Retrieving User Details
	
	public String searchUser(HttpServletRequest req, HttpServletResponse resp){
		try{
		pm.getObjectById(UserDetail.class, req.getParameter("email"));
		return "found";
		}
		catch(Exception e){
			return "notfound";
		}
	}
	public void setImage(HttpServletRequest req,  String pic){
		session=req.getSession();
		ud= pm.getObjectById(UserDetail.class, session.getAttribute("email"));
		ud.setPic(pic);
		ud.setPic(pic);
		session.setAttribute("prof_pic", "http://springbyhrishabh.appspot.com/serve?blobkey="+ud.getPic());
	}
	 

	
		
}
