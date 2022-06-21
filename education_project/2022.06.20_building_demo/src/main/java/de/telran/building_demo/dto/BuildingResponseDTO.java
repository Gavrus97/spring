package de.telran.building_demo.dto;

import lombok.Builder;

@Builder
public class BuildingResponseDTO {

    private Long id;
    private String street;
    private String houseNumber;
}
