package com.login;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class UserDetail {
	
	
	@PrimaryKey
	private String username;
	
	@Persistent
	private String password;
	
	@Persistent
	private String name;
	
	@Persistent
	private String dob;
	
	@Persistent
	private String contact;
	
	@Persistent
	private String city;
	
	@Persistent
	private String pic="AMIfv949WFw9tcdgK1za_PyOe7y_UoSWfWiOiLGk9_v-thF6TqVDWX-Yp8NQG5xdJ5PFu8n6fL8APYBBY4Vc6mBsssIU6W1TCTsw74jCuqSSWdettznlTQn3nn_iGb9lQS5gzz0mESCbeNspaCaUByIKODpnGFbZtDXdaBPMstY6gW-ofPYY8q8";
	
	@Persistent
	private long loginCount=1;
	
	public UserDetail() {
		
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setDob(String dob2){
		this.dob=dob2;
	}
	public String getDob(){
		return dob;
	}
	public void setContact(String contact){
		this.contact=contact;
	}
	public String getContact(){
		return contact;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getCity(){
		return city;
	}
	public void setLoginCount(long loginCount){
		this.loginCount=loginCount;
	}
	public long getLoginCount(){
		return loginCount;
	}

	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	

}
