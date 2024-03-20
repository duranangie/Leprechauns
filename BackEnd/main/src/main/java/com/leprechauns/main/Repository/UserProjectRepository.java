package com.leprechauns.main.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.UserProject;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Integer> {

    Optional<UserProject> findByUser (String user);
    
}
