package com.laioffer.communitymanagement.announcement;

import com.laioffer.communitymanagement.db.entity.AnnouncementEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public List<AnnouncementEntity> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    @PostMapping
    public AnnouncementEntity createAnnouncement(@RequestBody AnnouncementEntity announcementEntity) {
        return announcementService.createAnnouncement(announcementEntity);
    }

}
