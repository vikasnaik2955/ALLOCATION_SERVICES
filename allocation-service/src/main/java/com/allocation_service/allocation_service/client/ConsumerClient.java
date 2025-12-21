package com.allocation_service.allocation_service.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "consumer-service")
public interface ConsumerClient {

    @GetMapping("/consumer/{id}")
    Object getConsumer(@PathVariable UUID id);
}

