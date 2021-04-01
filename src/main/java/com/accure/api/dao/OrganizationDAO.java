package com.accure.api.dao;

import com.accure.api.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationDAO extends JpaRepository<Organization, Long> {
}
