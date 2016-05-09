package onight.zjfae.mfront.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.mgame.utils.PBInfo;
import onight.zjfae.afront.gens.PBIFEMessagemanageListMessage.PBIFE_messagemanage_listMessage;
import onight.zjfae.afront.gens.PBIFEMessagemanageListMessage.Ret_PBIFE_messagemanage_listMessage;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.Message;

@Slf4j
public class PBMessageFlatten {

	@Data
	public static class ModifyValue {
		public final static ModifyValue doNothing = new ModifyValue(null);
		private Object newValue;

		public ModifyValue(Object newValue) {
			super();
			this.newValue = newValue;
		}

	}

	public static abstract class FieldTracker {
		public abstract ModifyValue modTraceValue(Object v);

		public void traceAndModValue(Message.Builder builder, FieldDescriptor fd, Object v) {
			ModifyValue modv = modTraceValue(v);
			if (modv != null && modv != ModifyValue.doNothing) {
				builder.setField(fd, modv.newValue);
			}
		}

		public void traceAndModValue(Message.Builder builder, FieldDescriptor fd, Object v, int index) {
			ModifyValue modv = modTraceValue(v);
			if (modv != ModifyValue.doNothing) {
				builder.setRepeatedField(fd, index, modv.newValue);
			}
		}

	}

	public static void flattenMessage(List<FieldDescriptor> fds, FieldDescriptor curfd, String path, HashMap<String, List<FieldDescriptor>> fdByPath) {

		String itemName;
		if (path.length() > 0)
			itemName = path + "." + curfd.getName();
		else {
			itemName = curfd.getName();
		}

		if (curfd.getType() == Type.MESSAGE) {
			for (Iterator<FieldDescriptor> it = curfd.getMessageType().getFields().iterator(); it.hasNext();) {
				FieldDescriptor childfd = it.next();
				List<FieldDescriptor> chfds = new ArrayList<Descriptors.FieldDescriptor>();
				chfds.addAll(fds);
				chfds.add(childfd);
				flattenMessage(chfds, childfd, itemName, fdByPath);
			}
		} else {
			fdByPath.put(itemName, fds);
		}
	}

	public static HashMap<String, List<FieldDescriptor>> getFlattenMessage(Descriptor descriptor) {
		HashMap<String, List<FieldDescriptor>> fdByPath = new HashMap<>();

		for (Iterator<FieldDescriptor> it = descriptor.getFields().iterator(); it.hasNext();) {
			FieldDescriptor fd = it.next();
			List<FieldDescriptor> chfds = new ArrayList<Descriptors.FieldDescriptor>();
			chfds.add(fd);
			flattenMessage(chfds, fd, "", fdByPath);
		}
		return fdByPath;
	}

	public static void traceFields(Message.Builder builder, List<FieldDescriptor> fd, int depth, FieldTracker tracker) {
		if (fd == null || tracker == null)
			return;

		Object v = builder.getField(fd.get(depth));
		if (v == null) {
			tracker.traceAndModValue(builder, fd.get(depth), v);
		}
		if (depth < fd.size() - 1) {
			if (v instanceof Message) {
				traceFields(builder.getFieldBuilder(fd.get(depth)), fd, depth + 1, tracker);
			} else if (v instanceof List) {
				int i = 0;
				for (Object subv : (List) v) {
					if (subv instanceof Message) {
						traceFields(builder.getRepeatedFieldBuilder(fd.get(depth), i), fd, depth + 1, tracker);
					} else {
						tracker.traceAndModValue(builder.getRepeatedFieldBuilder(fd.get(depth), i), fd.get(depth), v, i);
						// tracker.onTraceValue(subv);
					}
					i++;
				}
			} else {
				log.debug("unknow type::" + v.getClass());
				// return null;
				// tracker.onTraceValue(null);
				tracker.traceAndModValue(builder, fd.get(depth), v);
			}
		} else {
			// tracker.onTraceValue(v);
			tracker.traceAndModValue(builder, fd.get(depth), v);
		}
	}

	public static Object getObjectByFields(Message message, List<FieldDescriptor> fd, int depth) {
		if (fd == null)
			return null;
		Object v = message.getField(fd.get(depth));
		if (v == null) {
			return null;
		}
		if (depth < fd.size() - 1) {
			if (v instanceof Message) {
				return getObjectByFields((Message) v, fd, depth + 1);
			} else if (v instanceof List) {
				if (((List) v).size() > 0) {
					Object subv = ((List) v).get(0);
					if (subv instanceof Message) {
						return getObjectByFields((Message) subv, fd, depth + 1);
					} else {
						return subv;
					}
				}
				log.info("list::" + v.getClass());
				return null;
			} else {
				log.debug("unknow type::" + v.getClass());
				return null;
			}
		} else {
			// log.debug("about to return:"+"v="+v+",class="+v.getClass()+",fd="+fd.get(depth));
			return v;
		}
	}

	public static void flattenPackage(String packname, HashMap<String, HashMap<String, List<FieldDescriptor>>> packMapper) {
		try {
			for (Class clazz : WrapClassLoader.getClasses(packname)) {
				try {
					PBInfo ano = (PBInfo) clazz.getAnnotation(PBInfo.class);
					if (ano == null)
						continue;
					Class pbretclazz = Class.forName("onight.zjfae.afront.gens." + WrapClassLoader.getCamelStr(ano.name()) + "$Ret_" + ano.name());
					Method m = pbretclazz.getDeclaredMethod("getDescriptor");
					Descriptor desc = (Descriptor) m.invoke(null);
					if (desc != null) {
						HashMap<String, List<FieldDescriptor>> flatinfo = getFlattenMessage(desc);
						if (flatinfo != null && flatinfo.size() > 0) {
							packMapper.put(ano.name(), flatinfo);
						}
					}
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ret_PBIFE_messagemanage_listMessage.Builder builder = Ret_PBIFE_messagemanage_listMessage.newBuilder();
		builder.setReturnCode("123").setReturnMsg("msg");
		PBIFE_messagemanage_listMessage.Builder data = PBIFE_messagemanage_listMessage.newBuilder();

		data.setPageInfo(PBIFE_messagemanage_listMessage.PageInfo.newBuilder().setPageCount("10").build());

		data.addMessageListList(PBIFE_messagemanage_listMessage.MessageListList.newBuilder().setContent("content111").build());
		data.addMessageListList(PBIFE_messagemanage_listMessage.MessageListList.newBuilder().setContent("content222").build());
		data.addMessageListList(PBIFE_messagemanage_listMessage.MessageListList.newBuilder().setContent("content333").build());
		data.addMessageListList(PBIFE_messagemanage_listMessage.MessageListList.newBuilder().setContent("content444").build());

		builder.setData(data.build());

		Ret_PBIFE_messagemanage_listMessage message = builder.build();

		HashMap<String, List<FieldDescriptor>> map = getFlattenMessage(PBIFE_messagemanage_listMessage.Builder.getDescriptor());
		System.out.println(map);
		System.out.println("pagecount=" + message.getData().getPageInfo().getPageCount());
		System.out.println("message==" + message);
		List<FieldDescriptor> fds = map.get("data.messageListList.content");
		System.out.println("result = " + getObjectByFields(message, fds, 0));

		traceFields(builder, fds, 0, new FieldTracker() {
			@Override
			public ModifyValue modTraceValue(Object v) {
				System.out.println("trace Field:" + v);
				if (!"content444".equals(v)) {
					return null;
				}
				return new ModifyValue("new values....");
			}
		});
		System.out.println("buildernew = " + builder.build());
		System.out.println("data.messageListList.content".matches("data.messageList.*content"));

		HashMap<String, HashMap<String, List<FieldDescriptor>>> packMapper = new HashMap<String, HashMap<String, List<FieldDescriptor>>>();

		flattenPackage("onight.mgame.autogens", packMapper);
		System.out.println("packMapper=" + packMapper.size());
		// try {
		// for (Class clazz :
		// WrapClassLoader.getClasses("onight.zjfae.afront.gens")) {
		// // System.out.println("clazz==" + clazz);
		// try {
		// Method m = clazz.getDeclaredMethod("getDescriptor");
		// Descriptor desc = (Descriptor) m.invoke(null);
		// if (desc != null) {
		// HashMap<String, List<FieldDescriptor>> flatinfo =
		// getFlattenMessage(desc);
		// System.out.println("flatinfo=" + flatinfo);
		// }
		// } catch (Exception e) {
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

}
