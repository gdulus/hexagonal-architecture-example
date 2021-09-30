package com.zenjob.hexagon.hexes.company.adapter.rest;

import com.zenjob.hexagon.hexes.company.application.ports.in.StoreCompanyUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static com.zenjob.hexagon.hexes.company.application.ports.in.StoreCompanyUseCase.CreateCompanyCommand;

@RestController
@RequiredArgsConstructor
@Slf4j
class CompanyRestController {

    private final StoreCompanyUseCase storeCompanyUseCase;

    @PostMapping("/companies")
    public CompletableFuture<CompanyResource> createCompany(@RequestBody final CompanyResource companyResource) {
        return CompletableFuture
                .supplyAsync(() -> CreateCompanyCommand.builder().name(companyResource.getName()).build())
                .thenCompose(createCompanyCommand -> storeCompanyUseCase.createCompany(createCompanyCommand))
                .thenApply(r -> new CompanyResource(r.getId(), r.getName()));
    }

}
