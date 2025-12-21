package com.allocation_service.allocation_service.service.impl;

import com.allocation_service.allocation_service.dto.AllocationRequest;
import com.allocation_service.allocation_service.entity.Allocation;
import com.allocation_service.allocation_service.repository.AllocationRepository;
import com.allocation_service.allocation_service.service.AllocationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AllocationServiceImpl implements AllocationService {

    private final AllocationRepository repo;

    public AllocationServiceImpl(AllocationRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Allocation allocateSafe(AllocationRequest r) {
        try {
            return allocate(r);
        } catch (Exception ex) {

            foodClient.cancelFood(r.getFoodId());

            throw new RuntimeException(
                    "Allocation failed, rolled back safely", ex);
        }
    }


    @Override
    public Allocation allocate(AllocationRequest r) {

        Allocation allocation = Allocation.builder()
                .foodId(r.getFoodId())
                .donorId(r.getDonorId())
                .consumerId(r.getConsumerId())
                .volunteerId(r.getVolunteerId())
                .transportId(r.getTransportId())
                .activityId(r.getActivityId())
                .build();

        Allocation saved = repo.save(allocation);

        foodClient.markFoodAllocated(r.getFoodId());
        volunteerClient.updateVolunteerStatus(
                r.getVolunteerId(), VolunteerStatus.BUSY);

        if (r.getTransportId() != null) {
            transportClient.updateTransportStatus(
                    r.getTransportId(), TransportStatus.BUSY);
        }

        return saved;
    }


    @Override
    public Allocation getById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Allocation not found"));
    }

    @Override
    public List<Allocation> getByConsumer(UUID consumerId) {
        return repo.findByConsumerId(consumerId);
    }

    @Override
    public void start(UUID id) {
        Allocation a = getById(id);
        a.setStatus(AllocationStatus.IN_PROGRESS);
        repo.save(a);
    }

    @Override
    public void complete(UUID id) {
        Allocation a = getById(id);
        a.setStatus(AllocationStatus.COMPLETED);
        a.setCompletedAt(LocalDateTime.now());
        repo.save(a);
    }

    @Override
    public void cancel(UUID id) {
        Allocation a = getById(id);
        a.setStatus(AllocationStatus.CANCELLED);
        repo.save(a);
    }
}

