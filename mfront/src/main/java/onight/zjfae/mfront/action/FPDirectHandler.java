package onight.zjfae.mfront.action;

import onight.tfw.async.CallBack;
import onight.tfw.async.CompleteHandler;
import onight.tfw.otransio.api.beans.FramePacket;

public abstract class FPDirectHandler implements CallBack<FramePacket> {

	CompleteHandler nextHandler;

	public FPDirectHandler(CompleteHandler nextHandler) {
		super();
		this.nextHandler = nextHandler;
	}

	public abstract void whenSuccess(FramePacket v);

	@Override
	public void onSuccess(FramePacket v) {
		whenSuccess(v);
	}

	public void onFailed(Exception e, FramePacket v) {
		onCompleted(v);
	}

	public void onCompleted(FramePacket v) {
		nextHandler.onFinished(v);
	}
}
