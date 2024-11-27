package com.laioffer.communitymanagement.amenity;

import com.laioffer.communitymanagement.db.entity.AmenityEntity;
import com.laioffer.communitymanagement.db.entity.AmenityReservationEntity;
import com.laioffer.communitymanagement.db.AmenityRepository;
import com.laioffer.communitymanagement.db.AmenityReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityReservationService {

    private final AmenityReservationRepository amenityReservationRepository;
    private final AmenityRepository amenityRepository;

    public AmenityReservationService(AmenityReservationRepository amenityReservationRepository, AmenityRepository amenityRepository) {
        this.amenityReservationRepository = amenityReservationRepository;
        this.amenityRepository = amenityRepository;
    }

    public List<AmenityEntity> getAllAmenities() {
        return (List<AmenityEntity>) amenityRepository.findAll();
    }

    public AmenityReservationEntity createReservation(AmenityReservationEntity reservation) {
        return amenityReservationRepository.save(reservation);
    }

    public List<AmenityReservationEntity> getReservationsByUserId(Long userId) {
        return amenityReservationRepository.findByUserId(userId);
    }
}
