package org.sid.secservice.dao;

import org.sid.secservice.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRolename (String rolename);
}
