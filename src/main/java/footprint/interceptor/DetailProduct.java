package footprint.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DetailProduct extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(); 
		if (request.getMethod().equalsIgnoreCase("GET")) { return true; }
		
		String role = (String)session.getAttribute("role");
		Long idAccount = (Long) session.getAttribute("idAccount"); 

		if (idAccount == null) { 	
			return true; 
		}
		if (!role.equals("user")) {
			response.sendRedirect(request.getContextPath() + "/dont-permission.htm"); 
		    return false;
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
