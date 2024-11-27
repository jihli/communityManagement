package com.laioffer.communitymanagement.db;

import com.laioffer.communitymanagement.db.entity.MaintenanceRequestEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRequestRepository extends ListCrudRepository<MaintenanceRequestEntity, Long> {
    List<MaintenanceRequestEntity> findByUserId(Long userId);
}
