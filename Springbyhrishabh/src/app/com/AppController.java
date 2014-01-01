package app.com;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import outh.fb.OuthFB;
import outh.google.OuthGoogle;
import storage.DataStorage;
import storage.Friends;

import com.email.SendEmail;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.login.Login;

@Controller
public class AppController  {
	Login login=new Login();
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	String bkey=null;
    
    @RequestMapping("/")
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         return "index";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    	
    	return login.doGet(req, resp);
	}
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    	
    	return login.logout(req, resp);
    }
    @RequestMapping("/outh2callback")
    public void outh(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException{
    	OuthGoogle outh=new OuthGoogle();
    	
			outh.work(req, resp);
    }
    @RequestMapping("/outh2facebook")
    public void FbOuth(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException{
    	OuthFB fb=new OuthFB();
    	fb.FbOuth(req, resp);
    }
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String register(){
    	return "register";
    }
    @RequestMapping("/detail")
    public String user(){
    	return "user";
    }
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public String newUser(HttpServletRequest req, HttpServletResponse resp){
    	DataStorage ds=new DataStorage();
    	System.out.println("in register" + req.getParameter("city"));
    	String msg;
    	msg = ds.addUser(req, resp, bkey );
			return msg;
    }
    
    @RequestMapping("/search")
    @ResponseBody
    public String search(HttpServletRequest req, HttpServletResponse resp){
    	DataStorage ds=new DataStorage();
    	System.out.println("search executed "+ds.searchUser(req, resp));
    	return  ds.searchUser(req, resp);
    	
    }
    
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update", method=RequestMethod.POST)
    public @ResponseBody String update(HttpServletRequest req, HttpServletResponse resp,@RequestParam("json")  String json) throws ParseException{
    	DataStorage ds=new DataStorage();
    	System.out.println("Update Executed   " +json);
    	Map<String, String> map=new HashMap<String, String>();
    	JSONParser parser=new JSONParser();
			map= (Map<String, String>) parser.parse(json);
			
			
			String str=ds.updateUser(req, resp, map);
			JSONObject obj=new JSONObject();
			obj.put("status", str);
			str=obj.toJSONString();
			System.out.println(str);
    	return  str;
    	
    }
	 @RequestMapping("/weeklyreport")
	    public void report(HttpServletRequest req, HttpServletResponse resp) throws MessagingException, IOException{
	    	SendEmail cron=new SendEmail();
	    	cron.sendMail("hrishabhkumar@gmail.com", "Hrishabh");
	    	System.out.println("report executed ");
	    }
	 @RequestMapping("/friend")
	 public String friends(){
		 return "friend";
	 }
	 @RequestMapping(value="/friend", method=RequestMethod.POST)
	    public @ResponseBody String searchFriend(HttpServletRequest req,HttpServletResponse resp, @RequestParam("json")  String json) throws ParseException{
	    	Friends frnd=new Friends();
	    	
	    	System.out.println("friend search Executed   " +json);
			String str=frnd.searchFriend(req, resp, json);
			System.out.println(str);
	    	return  str;
	    	
	    }
	 @RequestMapping(value="/image", method=RequestMethod.POST)
	 public void images(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		 Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		  List<BlobKey> blobKey = blobs.get("image");
		  System.out.println(blobKey.get(0));
		  BlobKey blobKey1=blobKey.get(0);
		  String bkey=blobKey1.getKeyString();
		  if(req.getSession().getAttribute("email")!=null){
			  DataStorage ds=new DataStorage();
			  String str=(String) req.getSession().getAttribute("email");
			  System.out.println(str);
			  ds.setImage(req, bkey);
		  }		  
	 }
	 
	
	 @RequestMapping("/serve")
	 public void serve(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 BlobKey blobKey = new BlobKey(req.getParameter("blobkey"));
		 blobstoreService.serve(blobKey, resp);
	 }
    
    
}