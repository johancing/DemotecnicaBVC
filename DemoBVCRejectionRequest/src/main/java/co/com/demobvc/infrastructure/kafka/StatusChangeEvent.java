package co.com.demobvc.infrastructure.kafka;

import java.util.List;

import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.config.Event;

public class StatusChangeEvent extends Event<List<Invoice>> {

}
