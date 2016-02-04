package onight.mgame.chats.cass.counter;

import lombok.Data;
import onight.tfw.cass.enums.Id;
import onight.tfw.cass.enums.Table;


@Table(name = "orderidunique", cacheAll=true)
public @Data class OrderidUnique {
	
	@Id
	private String key;
	
}

