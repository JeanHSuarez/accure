package com.accure.api.dao;

import com.accure.api.models.Role;
import com.accure.api.models.Roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
	Optional<Role> findByName(Roles name);
}
