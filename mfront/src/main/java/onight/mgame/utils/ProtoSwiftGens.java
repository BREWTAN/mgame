package onight.mgame.utils;

import java.util.HashMap;

import onight.sm.Ssm.PBSSO;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.WireFormat.FieldType;

public class ProtoSwiftGens {

	public static void main(String[] args) {
		try {
			Message message = PBSSO.newBuilder().build();
			System.out.println("builder==" + message.getAllFields());
			for (FieldDescriptor fd : PBSSO.getDescriptor().getFields()) {
				System.out.println("name=" + fd.getName() + "," + fd.getType()+",def="+fd.getDefaultValue());
				if (fd.getLiteType() == FieldType.MESSAGE) {
					System.out.println("aa=" + fd.getMessageType().getName());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
