package com.backvisitur.service;



import com.backvisitur.dtopackage.RoleDTO;

public interface RoleService {
	public abstract RoleDTO addRole(RoleDTO roleModel);
	public abstract RoleDTO findRoleById(Integer id);
}
