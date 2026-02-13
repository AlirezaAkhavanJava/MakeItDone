package com.arcade.makeitdone.service;

import com.arcade.makeitdone.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> taskLists();

    TaskList createTaskList(TaskList taskList);
}
