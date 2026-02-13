package com.arcade.makeitdone.repository;

import com.arcade.makeitdone.domain.entities.TaskList;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TaskListRepository extends JpaRepository<@NonNull TaskList, @NonNull UUID> {
}
