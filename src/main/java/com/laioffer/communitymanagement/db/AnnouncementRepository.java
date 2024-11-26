package com.laioffer.communitymanagement.db;
import com.laioffer.communitymanagement.db.entity.AnnouncementEntity;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity, Integer> {
    List<AnnouncementEntity> findByTitle(String title);
}
