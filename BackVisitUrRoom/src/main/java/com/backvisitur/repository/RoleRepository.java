package com.backvisitur.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backvisitur.constant.ERole;
import com.backvisitur.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Serializable> {
	public abstract Role findRoleById(Integer id);

	//public abstract Role findByName(String name);
	public Optional<Role> findByName(ERole name);
}
