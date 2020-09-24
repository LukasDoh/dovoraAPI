package com.dovora.dovoraAPI.repository;

import com.dovora.dovoraAPI.model.ERole;
import com.dovora.dovoraAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Role
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
