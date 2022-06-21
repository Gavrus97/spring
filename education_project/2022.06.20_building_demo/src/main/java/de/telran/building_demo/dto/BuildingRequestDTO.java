package de.telran.building_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BuildingRequestDTO {

    private String street;
    private String houseNumber;
    private Integer floorsCount;
}
