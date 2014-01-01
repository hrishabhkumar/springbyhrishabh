package outh.google;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

import outh.JsonParser;
import outh.OuthGeneral;

public class OuthGoogle {
	
	//Object to access Credentials.
	GooggleCredentials gc=new GooggleCredentials();
	
	//object to access OuthGeneral Class.
	OuthGeneral og=new OuthGeneral();
			

	public void work(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException{
		
	String data = "code="+og.code(req, resp)+"&client_id="+gc.getCLIENT_ID()+"&client_secret="+gc.getCLIENT_SECRET()+"&redirect_uri="+gc.getREDIRECT_URI()+"&grant_type="+gc.getGRANT_TYPE();
	String line=og.outh(gc.getTOKEN_URL(), "POST", data, req, resp);
	JsonParser parser = new JsonParser();	
	
	Map<String, String> json = parser.jsonParser(line);
	
	data="?access_token="+json.get("access_token");
	
	line=og.outh(gc.getUSER_INFO_URL()+data, "GET", null, req, resp);
	
	json=parser.jsonParser(line);
	HttpSession session=req.getSession();
	if(session.getAttribute("user")!=null){
		resp.sendRedirect("/login");
	}
	else{
		session.setAttribute("user", json.get("name"));
		session.setAttribute("prof_pic", json.get("picture"));
		session.setAttribute("email", json.get("email"));
		session.setAttribute("given_name", json.get("given_name"));
		resp.sendRedirect("/login");
	}
	}
}
