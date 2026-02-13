package com.arcade.makeitdone.mappers;

import com.arcade.makeitdone.domain.dto.TaskDto;
import com.arcade.makeitdone.domain.entities.Task;


public interface TaskMapper {

    public Task fromDto(TaskDto taskDto);

    public TaskDto toDto(Task task);

}


