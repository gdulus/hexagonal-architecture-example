package com.zenjob.hexagon.hexes.company.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.With;

@Data
@Builder
@With
public class Company {

    private final CompanyId id;

    @NonNull
    private final String name;
    
}
