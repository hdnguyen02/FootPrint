package footprint.helper.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import footprint.helper.CookieHelper;

public class CookieHelperImpl implements CookieHelper{
	@Override
	public String getValue(HttpServletRequest request, String cookieName) {
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null) return null; 
	
		for (Cookie cookie : cookies) { 
			String subCookieName = cookie.getName(); 
			if (cookieName.equals(subCookieName)) { 
				return cookie.getValue();
			}
		}
		return null;
	}
}
