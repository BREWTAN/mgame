package onight.zjfae.mfront.preproc;

import com.google.protobuf.Message;

import lombok.AllArgsConstructor;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.zjfae.mfront.utils.PBMessageFlatten.FieldTracker;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;

@AllArgsConstructor
public abstract class AbstractPreProc {
	protected APPIfacePreproc procs;
	
	public abstract boolean doPreProc(FramePacket fp);

}
