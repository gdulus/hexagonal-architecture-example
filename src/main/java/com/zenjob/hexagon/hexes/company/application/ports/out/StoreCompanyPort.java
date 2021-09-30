package com.zenjob.hexagon.hexes.company.application.ports.out;

import com.zenjob.hexagon.hexes.company.domain.Company;

import java.util.concurrent.CompletableFuture;

public interface StoreCompanyPort {

    CompletableFuture<Long> save(final Company company);

}
