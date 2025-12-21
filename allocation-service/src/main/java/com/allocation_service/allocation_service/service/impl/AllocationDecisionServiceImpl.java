package com.allocation_service.allocation_service.service.impl;

@Service
public class AllocationDecisionServiceImpl {

    private final VolunteerClient volunteerClient;
    private final TransportClient transportClient;

    public AllocationDecisionService(
            VolunteerClient volunteerClient,
            TransportClient transportClient
    ) {
        this.volunteerClient = volunteerClient;
        this.transportClient = transportClient;
    }

    public UUID chooseVolunteer(UUID activityId, String location) {
        // Phase 1: Activity volunteers
        // Phase 2: Available volunteers by location
        // (placeholder – logic evolves later)
        return UUID.randomUUID();
    }

    public UUID chooseTransport(String location) {
        // Phase 1: Available transports by location
        return UUID.randomUUID();
    }
}

