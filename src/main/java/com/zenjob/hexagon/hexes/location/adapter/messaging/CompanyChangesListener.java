package com.zenjob.hexagon.hexes.location.adapter.messaging;

import com.google.common.eventbus.Subscribe;
import com.zenjob.hexagon.hexes.company.domain.Company;
import com.zenjob.hexagon.common.messaging.MessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompanyChangesListener extends MessageListener {

    @Subscribe
    public void stringEvent(final Company event) {
        log.info("Company has changed {}", event);
    }

}
