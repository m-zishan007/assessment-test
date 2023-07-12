package com.coursehub.studentservice.repository;

import com.coursehub.studentservice.model.Role;
import com.coursehub.studentservice.model.SRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(SRole name);
}
