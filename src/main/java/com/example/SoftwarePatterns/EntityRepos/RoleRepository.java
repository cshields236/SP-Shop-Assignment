package com.example.SoftwarePatterns.EntityRepos;

import com.example.SoftwarePatterns.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
