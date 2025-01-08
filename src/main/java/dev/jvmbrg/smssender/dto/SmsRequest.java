package dev.jvmbrg.smssender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SmsRequest(
		String sender,
		int ddd,
		String phoneNumber,
		String message
) {
	//Notação para garantir que a no formato Json, os atributos tenham o mesmo nome que os parametros
	public SmsRequest(@JsonProperty("sender")String sender, 
					  @JsonProperty("ddd") int ddd, 
					  @JsonProperty("phoneNumber") String phoneNumber, 
					  @JsonProperty("message")String message) {
		this.sender = sender;
		this.ddd = ddd;
		this.phoneNumber = phoneNumber;
		this.message = message;
	}
	
	
	
}
