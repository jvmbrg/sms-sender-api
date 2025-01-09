package dev.jvmbrg.smssender.service;

import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;

import dev.jvmbrg.smssender.config.TwilioConfiguration;
import dev.jvmbrg.smssender.dto.SmsRequest;

//Classe responsavel por implementar a interface ISmsSender e fazer o envio do Sms com base nos parametros, destinatario, remetente e mensagem
//Esses dados vao ser passados para essa classe, que vai receber e construir o corpo do sms.
@Service("twilio")
public class TwilioSmsSenderService implements ISmsSender{
	
	public final TwilioConfiguration twilioConfiguration = null;

	@Override
	public void sendSms(SmsRequest smsRequest) {
		Message message = Message.creator(
			      new com.twilio.type.PhoneNumber("+55" + smsRequest.ddd() + smsRequest.phoneNumber()),
			      new com.twilio.type.PhoneNumber(twilioConfiguration.getTrialNumber()),
			      "Hello from Twilio"
				)
			      .create();
		
	}
}
