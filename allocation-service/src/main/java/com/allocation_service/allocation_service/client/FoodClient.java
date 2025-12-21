package com.allocation_service.allocation_service.client;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "donor-food-service")
public interface FoodClient {

    @PatchMapping("/food/{foodId}/allocate")
    void markFoodAllocated(@PathVariable UUID foodId);

    @PatchMapping("/food/{foodId}/cancel")
    void cancelFood(@PathVariable UUID foodId);
}

