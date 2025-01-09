package dev.jvmbrg.smssender.service;

import dev.jvmbrg.smssender.dto.SmsRequest;

public interface ISmsSender {
	void sendSms(SmsRequest smsRequest);
}
