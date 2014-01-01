package storage;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				JSONObject friendJson;
				JSONParser parser=new JSONParser();
				friendJson=(JSONObject) parser.parse(json);
				String name=friendJson.get("name").toString();
				Query query = pm.newQuery(UserDetail.class);
				query.setOrdering("name asc");
				String str = null;
				try{
					List<UserDetail> results = (List<UserDetail>) query.execute();
			
				  if (!results.isEmpty()) {
					  StringBuilder sb=new StringBuilder();
				    for (UserDetail userDetail : results) {
				      if(userDetail.getName().toLowerCase().contains(name.toLowerCase())){
				    	 str="{\"name\":\""+userDetail.getName()+"\""+ ",\n\"city\":\""+userDetail.getCity()+"\"},\n"; 
				    	 sb=sb.append(str+",");
				      }
				    }
				    str="{\"result\": ["+sb.toString()+"]}";
				    
				  } else {
				    // Handle "no results" case
			  }
			}finally {
				  query.closeAll();
				}
				friendJson=(JSONObject) parser.parse(str);
				str=friendJson.toJSONString();
				System.out.println(str);
				return str;
		}
		}catch(Exception e){
			return "error";
		}
		 
		
	}
}
