package com.laioffer.communitymanagement.maintenance;

import com.laioffer.communitymanagement.db.entity.MaintenanceRequestEntity;
import com.laioffer.communitymanagement.maintenance.MaintenanceRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance-requests")
public class MaintenanceRequestController {

    private final MaintenanceRequestService maintenanceRequestService;

    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequestEntity> createMaintenanceRequest(@RequestBody MaintenanceRequestEntity request) {
        MaintenanceRequestEntity createdRequest = maintenanceRequestService.createRequest(request);
        return ResponseEntity.ok(createdRequest);
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRequestEntity>> getRequestsByUserId(@RequestParam("user_id") Long userId) {
        List<MaintenanceRequestEntity> requests = maintenanceRequestService.getRequestsByUserId(userId);
        return ResponseEntity.ok(requests);
    }
}
