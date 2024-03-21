package com.leprechauns.main.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.UserProject;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Integer> {

    UserProject findByUsername(String username);
    
}
