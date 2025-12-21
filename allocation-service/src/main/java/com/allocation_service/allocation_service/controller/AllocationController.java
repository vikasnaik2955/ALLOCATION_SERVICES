package com.allocation_service.allocation_service.controller;

import com.allocation_service.allocation_service.dto.AllocationRequest;
import com.allocation_service.allocation_service.entity.Allocation;
import com.allocation_service.allocation_service.service.AllocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    private final AllocationService service;

    public AllocationController(AllocationService service) {
        this.service = service;
    }

    @PostMapping
    public Allocation allocate(@RequestBody AllocationRequest request) {
        return service.allocate(request);
    }


    @GetMapping("/{id}")
    public Allocation get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/consumer/{consumerId}")
    public List<Allocation> byConsumer(@PathVariable UUID consumerId) {
        return service.getByConsumer(consumerId);
    }

    @PatchMapping("/{id}/start")
    public void start(@PathVariable UUID id) {
        service.start(id);
    }

    @PatchMapping("/{id}/complete")
    public void complete(@PathVariable UUID id) {
        service.complete(id);
    }

    @PatchMapping("/{id}/cancel")
    public void cancel(@PathVariable UUID id) {
        service.cancel(id);
    }
}

