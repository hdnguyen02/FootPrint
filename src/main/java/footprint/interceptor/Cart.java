package footprint.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Cart extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
	
		if (session.getAttribute("ACCOUNT") != null && session.getAttribute("ROLE") != "USER") {
		    response.sendRedirect(request.getContextPath() + "/dont-permission.htm"); // trả về không có quyền truy cập tại đây -> không phải not-found 
		    return false;
		} 
		if (session.getAttribute("ACCOUNT") == null) { 
			response.sendRedirect(request.getContextPath() + "/sign-in.htm"); 
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}
