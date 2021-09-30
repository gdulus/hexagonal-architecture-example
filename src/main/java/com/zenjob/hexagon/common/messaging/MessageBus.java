package com.zenjob.hexagon.common.messaging;


import com.google.common.eventbus.EventBus;
import com.zenjob.hexagon.hexes.company.application.ports.out.NotifyOnCompanyChangePort;
import com.zenjob.hexagon.hexes.company.domain.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class MessageBus implements NotifyOnCompanyChangePort {

    private final EventBus bus;

    @Override
    public CompletableFuture<Boolean> nofity(Company company, String action) {
        return CompletableFuture
                .supplyAsync(() -> company)
                .thenApply(o -> {
                    bus.post(o);
                    return true;
                });
    }
}
