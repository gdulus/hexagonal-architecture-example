package com.zenjob.hexagon.hexes.company.application.ports.out;

import com.zenjob.hexagon.hexes.company.domain.Company;

import java.util.concurrent.CompletableFuture;

public interface NotifyOnCompanyChangePort {

    CompletableFuture<Boolean> nofity(final Company company, final String action);

}
