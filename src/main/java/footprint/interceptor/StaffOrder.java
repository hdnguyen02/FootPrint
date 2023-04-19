package footprint.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import footprint.service.MailService;

public class StaffOrder extends HandlerInterceptorAdapter {
	
	// khai báo gửi mail tại đây.
	@Autowired 
	private MailService mailService; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		return true; 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		// in ra trạng thái của đơn hàng sau khi cập nhập xem sao. 
		
		if (request.getMethod().equalsIgnoreCase("GET")) return; 
		
		if (modelAndView != null){ 
			ModelMap modelMap = modelAndView.getModelMap();
			String nameOrderStatus = (String)modelMap.get("order-status");
			String emailUser = (String)modelMap.get("mail-user");
			String subject = "đơn hàng của bạn đã: " + nameOrderStatus; 
	        mailService.sendMailAsync("hdnguyen7702@gmail", emailUser, "hdnguyen7702@gmail", "ĐƠN HÀNG TẠI FOOTPRINT", subject);  
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}
