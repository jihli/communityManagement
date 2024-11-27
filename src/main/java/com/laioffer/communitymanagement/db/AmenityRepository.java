package com.laioffer.communitymanagement.db;

import com.laioffer.communitymanagement.db.entity.AmenityEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends ListCrudRepository<AmenityEntity, Long> {
}
