package com.zenjob.hexagon.hexes.company.adapter.persistance;

import com.zenjob.hexagon.hexes.company.application.ports.out.StoreCompanyPort;
import com.zenjob.hexagon.hexes.company.domain.Company;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CompanyRepository implements StoreCompanyPort {

    @Override
    public CompletableFuture<Long> save(final Company company) {
        return CompletableFuture.supplyAsync(() -> 666L);
    }
}
