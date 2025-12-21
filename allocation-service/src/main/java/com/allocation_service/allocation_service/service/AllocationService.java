package com.allocation_service.allocation_service.service;

import com.allocation_service.allocation_service.dto.AllocationRequest;
import com.allocation_service.allocation_service.entity.Allocation;

import java.util.List;
import java.util.UUID;

public interface AllocationService {

    Allocation allocate(AllocationRequest request);

    Allocation getById(UUID id);

    List<Allocation> getByConsumer(UUID consumerId);

    void start(UUID allocationId);

    void complete(UUID allocationId);

    void cancel(UUID allocationId);
}

