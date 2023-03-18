package footprint.service;

public interface MailService {
	public String createOTP(); 
	public boolean sendOTP(String mail,String otp); 
}
