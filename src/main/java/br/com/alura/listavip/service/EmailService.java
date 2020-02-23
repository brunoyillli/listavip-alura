package br.com.alura.listavip.service;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void enviar(String nome, String emailDestinatario){
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("brunoenviar@gmail.com", "suasenha"));
			email.setSSLOnConnect(true);

			email.setFrom("brunoenviar@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("ola " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
			email.addTo(emailDestinatario);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
