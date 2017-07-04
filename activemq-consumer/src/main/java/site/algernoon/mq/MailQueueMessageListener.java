package site.algernoon.mq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSONObject;

import site.algernoon.entity.Mail;
import site.algernoon.service.MailService;

public class MailQueueMessageListener implements SessionAwareMessageListener<Message>{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination;
	
	@Autowired
	private MailService mailService;
	
	public synchronized void onMessage(Message message, Session session) {
		
		try {
			
			TextMessage msg = (TextMessage) message;
			
			String text = msg.getText();
			System.out.println("收到消息：" + text);
			
			Mail mail = JSONObject.parseObject(text, Mail.class);
			if(mail == null) {
				return;
			}
			
			mailService.sendMail(mail);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
