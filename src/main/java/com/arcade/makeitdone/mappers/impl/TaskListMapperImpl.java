package com.arcade.makeitdone.mappers.impl;

import com.arcade.makeitdone.domain.dto.TaskListDto;
import com.arcade.makeitdone.domain.entities.Task;
import com.arcade.makeitdone.domain.entities.TaskList;
import com.arcade.makeitdone.domain.entities.TaskStatus;
import com.arcade.makeitdone.mappers.TaskListMapper;
import com.arcade.makeitdone.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    @Override
    public TaskList mapDtoToTaskList(TaskListDto taskListDto) {
        return TaskList.builder()
                .id(taskListDto.id())
                .title(taskListDto.title())
                .description(taskListDto.description())
                .tasks(
                        Optional.ofNullable(taskListDto.tasks())
                                .map(
                                        tasks -> tasks.stream()
                                                .map(taskMapper::fromDto)
                                                .toList()
                                ).orElse(null)
                )
                .created(null)
                .updated(null)
                .build();
    }

    @Override
    public TaskListDto mapTaskListToDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks()).map(List::size).orElse(0),
                taskListProgressCalculation(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks()).map(tasks -> tasks.stream().map(taskMapper::toDto).toList()).orElse(null)

        );
    }


    private Double taskListProgressCalculation(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }
        long completed = tasks.stream().filter(task -> task.getStatus() == TaskStatus.COMPLETED).count();
        return completed / (double) tasks.size();

    }


}
