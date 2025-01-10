package dev.jvmbrg.smssender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;

import dev.jvmbrg.smssender.config.TwilioConfiguration;
import dev.jvmbrg.smssender.dto.SmsRequest;

//Classe responsavel por implementar a interface ISmsSender e fazer o envio do Sms com base nos parametros, destinatario, remetente e mensagem
//Esses dados vao ser passados para essa classe, que vai receber e construir o corpo do sms.
@Service("twilio")
public class TwilioSmsSenderService implements ISmsSender{
	
	private final TwilioConfiguration twilioConfiguration;
	
	//Mudança essencial para o funcionamento, sem isso, o programa dava exceção pois o trialNumber aparecia com o valor nulo.
	@Autowired
    public TwilioSmsSenderService(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

	@Override
	public void sendSms(SmsRequest smsRequest) {
		String from = "De: " + smsRequest.phoneNumber() + "\n";
		Message message = Message.creator(
			      new com.twilio.type.PhoneNumber("+55" + smsRequest.ddd() + smsRequest.phoneNumber()),
			      new com.twilio.type.PhoneNumber(twilioConfiguration.getTrialNumber()),
			      from + smsRequest.message()
				).create();	
	}
}
