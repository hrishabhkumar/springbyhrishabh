package com.email;

import java.io.IOException;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	
	Properties props=new Properties();
	  
	   
	
	Session session = Session.getInstance(props, null);
	public void sendMail(String email, String name) throws MessagingException, IOException{
			
		try {  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress("hrishabh.kumar@a-cti.com", "springbyhrishabh"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
			message.setSubject("Hi, "+name+" Welcome to springbyhrishabh");  
			String str="Click Here";
			String msg="<h1>Hello "+name+"</h1><br/>"+"<h2>You have successfilly registered at springbyhrishabh.</h2><br/>"+
					"Your Login Details: <br/><br/>"+"<b>User Name:</b> "+ email +"\n\n"+"<br/><a href='springbyhrishabh.appspot.com'>"+str+"</a> to Redirect <br/><br/>" ;
			message.setContent(msg,"text/html; charset=utf-8");
			//send message  
			Transport.send(message);  
			  
			System.out.println("message sent successfully");  
			   
		} 
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
