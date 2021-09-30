package com.zenjob.hexagon.hexes.company.application.ports.in;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.CompletableFuture;

public interface StoreCompanyUseCase {

    public CompletableFuture<StoreCompanyResult> createCompany(CreateCompanyCommand command);

    public CompletableFuture<StoreCompanyResult> updateCompany(UpdateCompanyCommand command);

    @Builder
    @Data
    class CreateCompanyCommand {
        final String name;
    }

    @Builder
    @Data
    class UpdateCompanyCommand {
        final Long id;
        final String name;
    }

    @Builder
    @Data
    class StoreCompanyResult {
        final Long id;
        final String name;
    }

}
