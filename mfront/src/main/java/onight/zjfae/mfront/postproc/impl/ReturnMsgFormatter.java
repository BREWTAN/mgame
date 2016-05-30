package onight.zjfae.mfront.postproc.impl;

import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message.Builder;

@Slf4j
@Formatter("retmsg")
public class ReturnMsgFormatter extends AbstractPostFieldTracker {

	public ReturnMsgFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	
	@Override
	public void traceAndModValue(Builder builder, FieldDescriptor fd, Object v) {
		traceAndModValue(builder,fd,v,0);
	}


	@Override
	public void traceAndModValue(Builder builder, FieldDescriptor fd, Object v, int index) {
		if(v==null||StringUtils.isBlank((String)v)){
			return;
		}
		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		if(patterns.length<2){
			return;
		}
		if(!((String)v).matches(patterns[0])){
			//不需要转换
			return;
		}
		String transvs[] = patterns[1].split("=");
		if(transvs.length<2){
			return;
		}
		String tf = transvs[0];
		String tv = transvs[1];
		for(Entry<Descriptors.FieldDescriptor, Object> entry:builder.getAllFields().entrySet()){
			FieldDescriptor vfd = entry.getKey();
			if(StringUtils.equals(vfd.getName(),tf)){
				builder.setField(vfd,tv);
			}
		}
	}


	@Override
	public ModifyValue modTraceValue(Object v) {
		return null;
	}
	public static void main(String[] args) {
		System.out.println(String.format("%.2f", 1.0));
	}
}
