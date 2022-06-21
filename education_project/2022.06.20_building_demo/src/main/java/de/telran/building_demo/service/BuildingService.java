package de.telran.building_demo.service;

import de.telran.building_demo.dto.BuildingResponseDTO;
import de.telran.building_demo.dto.BuildingRequestDTO;

import java.util.List;

public interface BuildingService {

    void createBuilding(BuildingRequestDTO request);

    List<BuildingResponseDTO> getAllBuildings();

    BuildingResponseDTO getBuildingById(Long id);
}
