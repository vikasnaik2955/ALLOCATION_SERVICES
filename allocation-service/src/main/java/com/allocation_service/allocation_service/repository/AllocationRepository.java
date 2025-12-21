package com.allocation_service.allocation_service.repository;

public interface AllocationRepository
        extends JpaRepository<Allocation, UUID> {

    List<Allocation> findByConsumerId(UUID consumerId);
    List<Allocation> findByVolunteerId(UUID volunteerId);
    List<Allocation> findByFoodId(UUID foodId);
}

