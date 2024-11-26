package com.laioffer.communitymanagement.announcement;

import com.laioffer.communitymanagement.db.AnnouncementRepository;
import com.laioffer.communitymanagement.db.entity.AnnouncementEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public List<AnnouncementEntity> getAllAnnouncements() {
        List<AnnouncementEntity> result = new ArrayList<>();
        this.announcementRepository.findAll().forEach(result::add);
        return result;
    }

    public AnnouncementEntity createAnnouncement(AnnouncementEntity announcementEntity) {
        return this.announcementRepository.save(announcementEntity);
    }
}
//    public void createAnnouncement(AnnouncementEntity announcement) {
//        announcements.add(announcement); // 添加公告到内存列表
//    }
//
//
//    public void deleteAnnouncement(int id) {
//        announcements.removeIf(a -> a.getId() == id); // 根据 ID 删除公告
//    }

