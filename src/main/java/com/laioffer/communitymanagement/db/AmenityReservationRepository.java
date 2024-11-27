package com.laioffer.communitymanagement.db;

import com.laioffer.communitymanagement.db.entity.AmenityEntity;
import com.laioffer.communitymanagement.db.entity.AmenityReservationEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityReservationRepository extends ListCrudRepository<AmenityReservationEntity, Long> {
    List<AmenityReservationEntity> findByUserId(Long userId);
}
