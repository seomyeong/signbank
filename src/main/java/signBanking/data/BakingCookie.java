package signBanking.data;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class BakingCookie {
	public static String getCookieValue(String param, HttpServletRequest request){
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals(param)) {
				cookieValue = c.getValue();
			}
		}
		return cookieValue;
	}
}