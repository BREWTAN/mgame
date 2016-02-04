package onight.mgame.chats.cass.counter;

import lombok.Data;
import onight.tfw.cass.enums.Id;
import onight.tfw.cass.enums.Table;


@Table(name = "messageidunique", cacheAll=true)
public @Data class MessageidUnique {
	
	@Id
	private String key;
	
}

