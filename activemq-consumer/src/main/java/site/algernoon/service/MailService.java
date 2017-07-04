package site.algernoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import site.algernoon.entity.Mail;

@Component
public class MailService {

	@Autowired  
    private JavaMailSender mailSender;
	
    @Autowired  
    private SimpleMailMessage simpleMailMessage;  
    
    @Autowired  
    private ThreadPoolTaskExecutor threadPool; 
	
	public void sendMail(final Mail mail) {
		
		threadPool.execute(new Runnable() {
			
			public void run() {
				try {

					simpleMailMessage.setTo(mail.getTo());
					simpleMailMessage.setSubject(mail.getSubject());
					simpleMailMessage.setText(mail.getContent());
					mailSender.send(simpleMailMessage);
				
				} catch (Exception e) {
					throw e;
				}
				
			}
		});
		
	}

}
