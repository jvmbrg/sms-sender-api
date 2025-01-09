package dev.jvmbrg.smssender.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.jvmbrg.smssender.dto.SmsRequest;
import dev.jvmbrg.smssender.service.ISmsSender;

@RestController
public class SmsSenderController {
	
	private final ISmsSender smsSender;
	
	//Aqui em vez de injetar a implementação, injetamos a interface da implementação demostrando qual a implementação vai ser aderidada 
	//atraves do comando @Qualifier junto com a referência ao serviço que deve ser implementado, no caso, o TwilioSmsSenderService 
	//nomeado como "twilio" e referenciado por meio do @Qualifier."
	public SmsSenderController(@Qualifier("twilio") ISmsSender smsSender) {
		this.smsSender = smsSender;
	}
	
	@PostMapping(value = "/send-sms")
	public void sendSms(@RequestBody SmsRequest smsRequest) {
		

	}
	
}
