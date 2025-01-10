package dev.jvmbrg.smssender.exceptions;

import java.time.LocalDateTime;

public record ExceptionDetails(String message, LocalDateTime timeStamp, int status, String exception) {
}
