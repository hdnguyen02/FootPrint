package footprint.helper;

import javax.servlet.http.HttpServletRequest;

public interface CookieHelper {
	public String getValue(HttpServletRequest request,String nameCookie);   
}
