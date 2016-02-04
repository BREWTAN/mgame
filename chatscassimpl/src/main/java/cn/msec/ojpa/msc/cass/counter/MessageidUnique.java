package cn.msec.ojpa.msc.cass.counter;

import lombok.Data;
import cn.msec.ojpa.cass.enums.Id;
import cn.msec.ojpa.cass.enums.Table;


@Table(name = "messageidunique", cacheAll=true)
public @Data class MessageidUnique {
	
	@Id
	private String key;
	
}

