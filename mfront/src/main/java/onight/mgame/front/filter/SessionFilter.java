package onight.mgame.front.filter;

import lombok.extern.slf4j.Slf4j;
import onight.mgame.front.action.ModuleStarter;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.otransio.api.PacketFilter;
import onight.tfw.otransio.api.beans.FramePacket;

import org.apache.felix.ipojo.annotations.Provides;

@iPojoBean
@Provides(specifications = { PacketFilter.class })
@Slf4j
public class SessionFilter implements PacketFilter {

	@Override
	public boolean postRoute(String module, FramePacket pack, CompleteHandler handler) {
		log.debug("postRoute:"+module+":" + pack);
		return false;
	}

	@Override
	public boolean preRoute(String module, FramePacket pack, CompleteHandler handler) {
		log.debug("preRoute:"+module+":" + pack);
		return false;
	}

	@Override
	public String[] modules() {
		return new String[] { ModuleStarter.MODULE_NAME };
	}

}
