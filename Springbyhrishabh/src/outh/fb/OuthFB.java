package outh.fb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;






import outh.OuthGeneral;

public class OuthFB {
	//Object to access Credentials.
	FBCredencials gc=new FBCredencials();
		
		//object to access OuthGeneral Class.
		OuthGeneral og=new OuthGeneral();
				

		public void FbOuth(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException{
			
		String code=req.getParameter("code");
		String addr = gc.getTOKEN_URL()+"?client_id="+gc.getCLIENT_ID()+"&redirect_uri="+gc.getREDIRECT_URI()+"&code="+code+"&client_secret="+gc.getCLIENT_SECRET();
		
		
			HttpURLConnection connection=null;
			URL url=null;
			try{
				url = new URL(addr);
				
				connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				
				//Checking Response code.
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					System.out.println("Response message-> "+ connection.getInputStream());
					System.out.print("got response");
					
					InputStream is=connection.getInputStream();
					InputStreamReader in=new InputStreamReader(is);			
					BufferedReader br=new BufferedReader(in);
					String line=br.readLine();
					int a=line.indexOf('&');
					int b=line.indexOf('=')+1;
					
					String input_token=line.substring(b, a);
					connection.disconnect();
				
					
					addr="https://graph.facebook.com/me?access_token="+input_token;
				
					url = new URL(addr);
					connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					connection.setRequestMethod("GET");
					connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				
					//Checking Response code.
					if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
						System.out.println("Response message-> "+ connection.getInputStream());
						System.out.print("got response");
						
						is=connection.getInputStream();
						in=new InputStreamReader(is);			
						br=new BufferedReader(in);
						line=br.readLine();
						
						connection.disconnect();
					
						
					JSONObject obj=new JSONObject();
					JSONParser parser= new JSONParser();
					obj= (JSONObject) parser.parse(line);
					String user_id=obj.get("id").toString();
					String email=obj.get("email").toString();
					String fields="?fields=id,name,first_name,last_name,picture";
					
					addr="https://graph.facebook.com/"+user_id+fields;
					
					url = new URL(addr);
					connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					connection.setRequestMethod("GET");
					connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
					
					//Checking Response code.
					if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
						System.out.println("Response message-> "+ connection.getInputStream());
						System.out.print("got response");
						
						is=connection.getInputStream();
						in=new InputStreamReader(is);			
						br=new BufferedReader(in);
						
						line=br.readLine();
						
						connection.disconnect();
						
						
						obj=(JSONObject) parser.parse(line);
						String name=obj.get("name").toString();
						String fname=obj.get("first_name").toString();
						obj=(JSONObject) obj.get("picture");
						obj=(JSONObject) obj.get("data");
						String pic=obj.get("url").toString();
						
					HttpSession session=req.getSession();
					if(session.getAttribute("user")!=null){
						resp.sendRedirect("/login");
					}
					session.setAttribute("user", name);
					session.setAttribute("prof_pic", pic);
					session.setAttribute("email", email);
					session.setAttribute("given_name", fname);
					resp.sendRedirect("/login");
					}
					}
				} 
				else {
					System.out.print("bad response");
					HttpSession session=req.getSession();
					session.setAttribute("user","Sorry!! There is some problem <br/> Response code: "+connection.getResponseCode() );
					resp.sendRedirect("/login");
					
				}	
//			}
			}
			catch(Exception e){
				resp.sendRedirect("/login");
				
			}
		
		
		}
}
