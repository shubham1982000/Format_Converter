package com.example.taskTwoThree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskTwoThree.entity.DBWriterEntity;


@Repository
public interface DBWriterRepo extends JpaRepository<DBWriterEntity, Integer> {}




