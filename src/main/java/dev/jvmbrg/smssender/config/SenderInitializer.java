package dev.jvmbrg.smssender.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

//Classe de configuração do enviador de mensagem, nesse caso, é o Twilio então chamamos o TwilioConfiguration
@Configuration
public class SenderInitializer {
	public static Logger logger = Logger.getLogger(SenderInitializer.class.getName());
	public SenderInitializer(TwilioConfiguration senderConfiguration) {
		//Metedo de inicialização do Twilio, onde passamos os tokens para a chamada do metodo
		Twilio.init(senderConfiguration.getAccountSid(), senderConfiguration.getAuthToken());
		
		logger.info("Twilio initialized with account sid: " + senderConfiguration.getAccountSid() + "auth token: "+
		senderConfiguration.getAuthToken() + "and trial number: " + senderConfiguration.getTrialNumber());
	}
}
