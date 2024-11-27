package com.laioffer.communitymanagement.maintenance;

import com.laioffer.communitymanagement.db.entity.MaintenanceRequestEntity;
import com.laioffer.communitymanagement.db.MaintenanceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceRequestService {

    private final MaintenanceRequestRepository maintenanceRequestRepository;

    public MaintenanceRequestService(MaintenanceRequestRepository maintenanceRequestRepository) {
        this.maintenanceRequestRepository = maintenanceRequestRepository;
    }

    public MaintenanceRequestEntity createRequest(MaintenanceRequestEntity request) {
        return maintenanceRequestRepository.save(request);
    }

    public List<MaintenanceRequestEntity> getRequestsByUserId(Long userId) {
        return maintenanceRequestRepository.findByUserId(userId);
    }
}
