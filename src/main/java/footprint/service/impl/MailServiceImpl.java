package footprint.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.internet.MimeMessage;

import footprint.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String createOTP() {
		Random random = new Random(); 

		
		String otp = ""; 
		
		for (int i = 0;i < 6;i++) {
			otp = otp + random.nextInt(10);
		}
		return otp;
	}
	
	@Override
	public void sendOTP(String mailUser,String otp) {
		String subject = "OTP"; 
		this.sendMailAsync("hdnguyen7702@gmail.com",mailUser,"hdnguyen7702@gmail.com",subject,otp);
	}
	
	
	@Override
	public boolean sendMail (String from,String to,String reppy,String subject,String text) { 
		try {
			MimeMessage message  = javaMailSender.createMimeMessage(); 
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from, from); 
			helper.setReplyTo(from); 
			helper.setTo(to); 
			helper.setSubject(subject); 
			helper.setText(text); 
			javaMailSender.send(message); 
			return true; 
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void sendMailAsync(String from,String to,String reppy,String subject,String text) { 
		ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> { // cơ chế aysnc 
        	sendMail(from,to,reppy,subject,text); 
        });	
        
    
       
        executorService.shutdown();
	}
}
