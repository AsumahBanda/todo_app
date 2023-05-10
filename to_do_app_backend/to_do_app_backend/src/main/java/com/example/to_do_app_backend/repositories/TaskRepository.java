package com.example.to_do_app_backend.repositories;

import com.example.to_do_app_backend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleAndStatus(String title, boolean status);

    List<Task> findByUserId(@Param("userId") Long UserId);

    void findBy();
}

