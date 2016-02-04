package cn.msec.ojpa.msc.cass.counter;

import lombok.Data;
import cn.msec.ojpa.cass.enums.Counter;
import cn.msec.ojpa.cass.enums.Id;
import cn.msec.ojpa.cass.enums.Table;

@Table(name = "messagecounter")
public @Data class MessageCounter {

	@Id
	private String key;
	@Counter
	private long successnum;
	@Counter
	private long faildnum;
	@Counter
	private long ordernos;
	@Counter
	private long totalnum;

}
