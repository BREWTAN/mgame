package cn.msec.ojpa.msc.cass.counter;

import lombok.Data;
import cn.msec.ojpa.cass.enums.Id;
import cn.msec.ojpa.cass.enums.Table;


@Table(name = "orderidunique", cacheAll=true)
public @Data class OrderidUnique {
	
	@Id
	private String key;
	
}

