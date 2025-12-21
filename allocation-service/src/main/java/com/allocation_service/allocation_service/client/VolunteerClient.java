package com.allocation_service.allocation_service.client;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "logistics-service")
public interface VolunteerClient {

    @PatchMapping("/volunteers/{id}/status")
    void updateVolunteerStatus(
            @PathVariable UUID id,
            @RequestParam VolunteerStatus status
    );
}

