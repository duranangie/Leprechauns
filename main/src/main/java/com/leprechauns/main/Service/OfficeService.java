package com.leprechauns.main.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.DTO.OfficeDTO;
import com.leprechauns.main.Entity.Office;
import com.leprechauns.main.Repository.OfficeRepository;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<OfficeDTO> getAllOffices() {
        return officeRepository.findAll().stream()
                .map(Office::toDTO)
                .toList();
    }
}