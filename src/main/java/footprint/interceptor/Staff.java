package footprint.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Staff extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		
		HttpSession session = request.getSession();
		String idAccount = (String) session.getAttribute("idEmployee"); // 
		System.out.println("ROLE" + " " + (String) session.getAttribute("role"));
 
		if (idAccount == null) { // chưa có đăng nhập
			response.sendRedirect(request.getContextPath() + "/sign-in-employee.htm");
			return false;
		}	
		String role = (String) session.getAttribute("role"); // 
		System.out.println(role + " role nè");
		if (!role.equals("STAFF")) {
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