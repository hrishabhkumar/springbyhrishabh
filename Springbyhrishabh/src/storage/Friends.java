package storage;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.login.PMF;
import com.login.UserDetail;
public class Friends {
	PersistenceManager pm = PMF.getPMF().getPersistenceManager();
	HttpSession session;
	@SuppressWarnings("unchecked")
	public String searchFriend(HttpServletRequest req,HttpServletResponse resp, String json) throws ParseException{
		
		try{
			session=req.getSession();
			if(session.getAttribute("user")==null){
				resp.sendRedirect("/login");
				return "error";
			}
			
			else{
				System.out.println();
				JSONObject friendJson;
				JSONParser parser=new JSONParser();
				friendJson=(JSONObject) parser.parse(json);
				String name=friendJson.get("name").toString();
				Query query = pm.newQuery(UserDetail.class);
				query.setOrdering("name asc");
				
				try{
					List<UserDetail> results = (List<UserDetail>) query.execute();
			
				  if (!results.isEmpty()) {
					  JSONArray responseArray=new JSONArray();
				    for (UserDetail userDetail : results) {
				      if(userDetail.getName().toLowerCase().contains(name.toLowerCase())){
				    	  friendJson=new JSONObject();
				    	  friendJson.put("name", userDetail.getName());
				    	  friendJson.put("city", userDetail.getCity());
				    	  responseArray.add(friendJson);
				      }
				    }
				    friendJson=new JSONObject();
				    friendJson.put("result", responseArray.toJSONString());
				    
				  } else {
				    // Handle "no results" case
			  }
			}finally {
				  query.closeAll();
				}
				System.out.println(friendJson);
				return friendJson.toJSONString();
		}
		}catch(Exception e){
			return "error";
		}
		 
		
	}
}
