package cl.praxis.controlReclamosTransporte.model.service;

import cl.praxis.controlReclamosTransporte.model.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Integer id);
    boolean create(Role role);
    boolean update(Role role);
    boolean delete(Integer id);
}