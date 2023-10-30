package com.example.demo.dtos;

import ch.qos.logback.core.status.Status;

public record PetOutputDto(
    Long id,
    String name,
    Status status
) {
    
}
