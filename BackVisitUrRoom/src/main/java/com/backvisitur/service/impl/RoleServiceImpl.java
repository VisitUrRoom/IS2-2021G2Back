package com.backvisitur.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.backvisitur.dtopackage.RoleDTO;
import com.backvisitur.entity.Role;
import com.backvisitur.repository.RoleRepository;
import com.backvisitur.service.RoleService;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired // Se Inyecta el repositorio
	@Qualifier("roleRepository")
	private RoleRepository roleRepository;

	@Override
	public RoleDTO addRole(RoleDTO roleDTO) {

		/**
		 * Los valores de Role a Role DTO y DTO a Role se puede Implementar enun
		 * RoleCoverter
		 */
		Role role = new Role();
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		roleRepository.save(role);
		roleDTO.setId(role.getId());
		roleDTO.setRoleName(role.getName());
		return roleDTO;
	}

	@Override
	public RoleDTO findRoleById(Integer id) {
		if (roleRepository.findById(id).isPresent()) {
			Role role = roleRepository.findRoleById(id);
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setId(role.getId());
			roleDTO.setRoleName(role.getName());
			return roleDTO;
		} else {
			return null;
		}
	}
}
