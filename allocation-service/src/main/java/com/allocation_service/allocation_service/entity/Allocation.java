package com.allocation_service.allocation_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "allocations")
public class Allocation extends BaseEntity {

    @Column(nullable = false)
    private UUID foodId;

    @Column(nullable = false)
    private UUID donorId;

    @Column(nullable = false)
    private UUID consumerId;

    @Column(nullable = false)
    private UUID volunteerId;

    private UUID transportId;
    private UUID activityId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AllocationStatus status = AllocationStatus.REQUESTED;

    private LocalDateTime allocatedAt;
    private LocalDateTime completedAt;

    public Allocation() {}

    private Allocation(Builder b) {
        this.foodId = b.foodId;
        this.donorId = b.donorId;
        this.consumerId = b.consumerId;
        this.volunteerId = b.volunteerId;
        this.transportId = b.transportId;
        this.activityId = b.activityId;
        this.status = b.status != null ? b.status : AllocationStatus.REQUESTED;
        this.allocatedAt = LocalDateTime.now();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID foodId;
        private UUID donorId;
        private UUID consumerId;
        private UUID volunteerId;
        private UUID transportId;
        private UUID activityId;
        private AllocationStatus status;

        public Builder foodId(UUID v){ this.foodId=v; return this; }
        public Builder donorId(UUID v){ this.donorId=v; return this; }
        public Builder consumerId(UUID v){ this.consumerId=v; return this; }
        public Builder volunteerId(UUID v){ this.volunteerId=v; return this; }
        public Builder transportId(UUID v){ this.transportId=v; return this; }
        public Builder activityId(UUID v){ this.activityId=v; return this; }
        public Builder status(AllocationStatus v){ this.status=v; return this; }

        public Allocation build(){
            if(foodId==null||donorId==null||consumerId==null||volunteerId==null)
                throw new IllegalStateException("Missing required fields");
            return new Allocation(this);
        }
    }
}

