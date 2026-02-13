package com.arcade.makeitdone.service.impl;

import com.arcade.makeitdone.domain.entities.TaskList;
import com.arcade.makeitdone.repository.TaskListRepository;
import com.arcade.makeitdone.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Override
    public List<TaskList> taskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }
}
