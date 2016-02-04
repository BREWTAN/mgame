package cn.msec.ojpa.msc.cass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import cn.msec.ojpa.cass.enums.Indexed;
import cn.msec.ojpa.cass.enums.KeyColumn;
import cn.msec.ojpa.cass.enums.KeyPart;
import cn.msec.ojpa.cass.enums.Table;

@Table(name = "transbuffermsg")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class TransBufferMsg {
	

	@Indexed
	private String status;
	
	@Indexed
	private String postDate;//下一个处理时间

	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String id;
	
	
	private String queueName;//队列id号
	
	private String transType;

	private String productId;

	private String bodyStr;

}