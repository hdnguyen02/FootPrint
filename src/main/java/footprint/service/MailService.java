package footprint.service;

public interface MailService {
	public String createOTP(); 
	public void sendOTP(String mail,String otp); 
	public boolean sendMail (String from,String to,String reppy,String subject,String text); 
	public void sendMailAsync(String from,String to,String reppy,String subject,String text);
}
