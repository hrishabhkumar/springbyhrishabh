package outh.google;

public class GooggleCredentials {
	private final String CLIENT_ID="854504709839-g6h8lb5pidkqqu6gk5g9qgeup3cphv5p.apps.googleusercontent.com";
	private final String CLIENT_SECRET="Z7NrHjGnL6CaWDjp0QfLAU57";
	private final String REDIRECT_URI="http://springbyhrishabh.appspot.com/outh2callback";
	private final String GRANT_TYPE="authorization_code";
	private final String USER_INFO_URL="https://www.googleapis.com/oauth2/v2/userinfo";
	private final String TOKEN_URL="https://accounts.google.com/o/oauth2/token";
	
	
	public String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public String getCLIENT_SECRET() {
		return CLIENT_SECRET;
	}

	public String getREDIRECT_URI() {
		return REDIRECT_URI;
	}

	public String getGRANT_TYPE() {
		return GRANT_TYPE;
	}

	public String getUSER_INFO_URL() {
		return USER_INFO_URL;
	}

	public String getTOKEN_URL() {
		return TOKEN_URL;
	}

}
