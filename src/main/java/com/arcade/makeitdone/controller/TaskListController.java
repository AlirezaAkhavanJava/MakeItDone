package com.arcade.makeitdone.controller;

import com.arcade.makeitdone.domain.dto.TaskListDto;
import com.arcade.makeitdone.mappers.TaskListMapper;
import com.arcade.makeitdone.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;


    // ============ SHOW ALL THE TASK LIST'S (DTO) ===============
    @GetMapping
    public List<TaskListDto> taskLists() {
        return taskListService.taskLists()
                .stream()
                .map(taskListMapper::mapTaskListToDto)
                .toList();
    }

}
