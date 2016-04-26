package onight.zjfae.mfront.service;

import com.google.protobuf.Message;

import onight.zjfae.mfront.service.IFEBeanMapping.PreProc;


public class RegPrepProc implements PreProc {

	@Override
	public boolean prepDO(Message message, String pbname) {
		return false;

	}

}
