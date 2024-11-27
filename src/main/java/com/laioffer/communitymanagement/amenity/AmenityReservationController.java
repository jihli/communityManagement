package com.laioffer.communitymanagement.amenity;

import com.laioffer.communitymanagement.db.entity.AmenityReservationEntity;
import com.laioffer.communitymanagement.db.entity.AmenityEntity;
import com.laioffer.communitymanagement.amenity.AmenityReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amenity-reservations")
public class AmenityReservationController {

    private final AmenityReservationService amenityReservationService;

    public AmenityReservationController(AmenityReservationService amenityReservationService) {
        this.amenityReservationService = amenityReservationService;
    }

    @GetMapping("/amenities")
    public ResponseEntity<List<AmenityEntity>> getAllAmenities() {
        List<AmenityEntity> amenities = amenityReservationService.getAllAmenities();
        return ResponseEntity.ok(amenities);
    }

    @PostMapping
    public ResponseEntity<AmenityReservationEntity> createAmenityReservation(@RequestBody AmenityReservationEntity reservation) {
        AmenityReservationEntity createdReservation = amenityReservationService.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    @GetMapping
    public ResponseEntity<List<AmenityReservationEntity>> getReservationsByUserId(@RequestParam("user_id") Long userId) {
        List<AmenityReservationEntity> reservations = amenityReservationService.getReservationsByUserId(userId);
        return ResponseEntity.ok(reservations);
    }
}
