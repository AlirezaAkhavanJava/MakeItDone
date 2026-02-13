package com.arcade.makeitdone.mappers.impl;

import com.arcade.makeitdone.domain.dto.TaskDto;
import com.arcade.makeitdone.domain.entities.Task;
import com.arcade.makeitdone.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromDto(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.id())
                .title(taskDto.title())
                .description(taskDto.description())
                .status(taskDto.status())
                .priority(taskDto.priority())
                .taskList(null)
                .createdDate(null)
                .updated(null)
                .build();
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
