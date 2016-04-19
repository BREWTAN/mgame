package cn.msec.bval.exception;

import lombok.Getter;

public class ITradeMsgException extends RuntimeException {

	@Getter
	ITRD_Message tradeMessage;

	public ITradeMsgException(ITRD_Message tradeMessage, Throwable cause) {
		super(tradeMessage.toString(), cause);
		this.tradeMessage = tradeMessage;
	}

	public ITradeMsgException(ITRD_Message tradeMessage) {
		super(tradeMessage.toString());
		this.tradeMessage = tradeMessage;
	}
}
