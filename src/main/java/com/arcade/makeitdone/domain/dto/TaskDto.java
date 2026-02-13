package com.arcade.makeitdone.domain.dto;

import com.arcade.makeitdone.domain.entities.TaskPriority;
import com.arcade.makeitdone.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
