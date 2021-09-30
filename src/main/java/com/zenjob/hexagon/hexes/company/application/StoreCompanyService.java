package com.zenjob.hexagon.hexes.company.application;

import com.zenjob.hexagon.hexes.company.application.ports.in.StoreCompanyUseCase;
import com.zenjob.hexagon.hexes.company.application.ports.out.NotifyOnCompanyChangePort;
import com.zenjob.hexagon.hexes.company.application.ports.out.StoreCompanyPort;
import com.zenjob.hexagon.hexes.company.domain.Company;
import com.zenjob.hexagon.hexes.company.domain.CompanyId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class StoreCompanyService implements StoreCompanyUseCase {

    private final StoreCompanyPort storeCompanyPort;

    private final NotifyOnCompanyChangePort companyChangePort;

    @Override
    public CompletableFuture<StoreCompanyResult> createCompany(final CreateCompanyCommand command) {
        return CompletableFuture
                .supplyAsync(() ->
                        Company.builder().name(command.getName()).build())
                .thenCompose(company ->
                        storeCompanyPort.save(company).thenApply(id -> company.withId(new CompanyId(id))))
                .thenApply(company -> {
                    companyChangePort.nofity(company, "created");
                    return company;
                })
                .thenApply(company ->
                        StoreCompanyResult.builder()
                                .id(company.getId().getId())
                                .name(command.getName())
                                .build());
    }

    @Override
    public CompletableFuture<StoreCompanyResult> updateCompany(final UpdateCompanyCommand command) {
        return CompletableFuture
                .supplyAsync(() -> Company.builder().id(new CompanyId(command.getId())).build())
                .thenCompose(storeCompanyPort::save)
                .thenApply(id ->
                        StoreCompanyResult.builder()
                                .id(id)
                                .name(command.getName())
                                .build());
    }
}
