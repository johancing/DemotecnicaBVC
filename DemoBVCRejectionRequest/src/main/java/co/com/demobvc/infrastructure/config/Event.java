package co.com.demobvc.infrastructure.config;

import java.util.Date;
import lombok.Data;

@Data
public abstract class Event<T> {

	private String id;
	private String user;
	private Date date;
	private EventType type;
	private T data;
}
