package com.leprechauns.main.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.Office;
import com.leprechauns.main.Entity.DTO.OfficeDTO;
import com.leprechauns.main.Repository.OfficeRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    private OfficeDTO convertToObject(Object[] objects, Map<String, Integer> propertyIndices) {
        if (objects == null || objects.length < propertyIndices.size()) {
            throw new IllegalArgumentException("The array of objects is null or doesn't have enough elements");
        }
        OfficeDTO dto = new OfficeDTO();
        propertyIndices.forEach((propertyName, index) -> {
            switch (propertyName) {
                case "officeCode":
                    dto.setOfficeCode((String) objects[index]);
                    break;
                case "city":
                    dto.setCity((String) objects[index]);
                    break;
                case "country":
                    dto.setCountry((String) objects[index]);
                    break;
                case "region":
                    dto.setRegion((String) objects[index]);
                    break;
                case "postalCode":
                    dto.setPostalCode((String) objects[index]);
                    break;
                case "phone":
                    dto.setPhone((String) objects[index]);
                    break;
                case "address1":
                    dto.setAddressLine1((String) objects[index]);
                    break;
                case "address2":
                    dto.setAddressLine2((String) objects[index]);
                    break;
                }
            }
        );
        return dto;
    }

    public List<OfficeDTO> getOfficeDTOListFromObjectArray(List<Object[]> objectList, Map<String, Integer> propertyIndices) {
        return objectList.stream()
                .map(objects -> convertToObject(objects, propertyIndices))
                .collect(Collectors.toList());
    }

    // Queries

    public List<OfficeDTO> getAllOffices() {
        return officeRepository.findAll().stream()
                .map(Office::toDTO)
                .toList();
    }

    public List<OfficeDTO> findOfficesSpain() {
        List<Object[]> objectList = officeRepository.findOfficeSpain();
        Map<String, Integer> propertyIndices = Map.of("phone", 0, "city", 1);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    }
    
    public List<OfficeDTO> findOfficeCodeAndCity() {
        List<Object[]> objectList = officeRepository.findOfficeCodeAndCity();
        Map<String, Integer> propertyIndices = Map.of("officeCode", 0, "city", 1);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    }
    
<<<<<<< HEAD
    // public List<OfficeDTO> findOfficeAddress(){
    //     List<Object[]> objectList = officeRepository.findOfficeAddress();
    //     Map<String, Integer> propertyIndices = Map.of("officeCode", 0, "city", 1);
    //     return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    // }

    
=======
    // public List<String> findOfficeAddress(){
    //     return officeRepository.findOfficeAddress();
    // }

    // public List<OfficeDTO> findOfficeAddress(){
    //     List<Object[]> objectList = officeRepository.findOfficeAddress();
    //     Map<String, Integer> propertyIndices = Map.of("address1", 0, "address2", 1);
    //     return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    // }

    public List<OfficeDTO> findOfficeDontWorkEmployeeRangeFrutales(){
        List<Object[]> objectList = officeRepository.findOfficeEmployeeDontWorkEachProductFrutal();
        Map<String, Integer> propertyIndices = Map.of("officeCode", 0);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    }
>>>>>>> 095b01a05ad4dd24c4e8f90788329bf2dc4504fd
    
}