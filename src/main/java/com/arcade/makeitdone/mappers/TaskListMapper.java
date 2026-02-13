package com.arcade.makeitdone.mappers;

import com.arcade.makeitdone.domain.dto.TaskListDto;
import com.arcade.makeitdone.domain.entities.TaskList;


public interface TaskListMapper {

    TaskList mapDtoToTaskList(TaskListDto taskListDto);

    TaskListDto mapTaskListToDto(TaskList taskList);

}
