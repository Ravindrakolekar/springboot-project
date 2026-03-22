package com.project.springboot.repo;

import com.project.springboot.model.RecordRequestPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepoClass extends JpaRepository<RecordRequestPayload,Integer> {


}
