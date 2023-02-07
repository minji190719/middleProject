package kr.or.ddit.payment.controller;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Commons_attatch {

	public static void main(String[] args) {
		
	}
	
	public void sendEmail() throws EmailException {
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\eclipse\\bill/bill_1.png");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("2022_10_25_주문내역서");
		attachment.setName("2022_10_25_주문내역서.png");
		
		// Create the email message
		MultiPartEmail email1 = new MultiPartEmail();
		email1.setAuthenticator(new DefaultAuthenticator("nang1825@naver.com", "sa!tdesert7"));
		email1.setHostName("smtp.naver.com");
		email1.addTo("fnvkfl12@naver.com", "조현수");
		email1.setFrom("fnvkfl12@naver.com", "조현수");
		email1.setSubject("나이키 비공식몰 주문서 발송 ");
		email1.setMsg("나이키 비공식 몰 주문내역 발송 안내");
		
		// add the attachment
		email1.attach(attachment);
		
		// send the email
		email1.send();
		System.out.println("이메일 되는겨?");
	}
		
		
		


}
