package com.falynsky.event;

import java.io.Serializable;
import java.util.UUID;

public interface DomainIncomingEvent extends Serializable {
    UUID getAggregateId();
}
