package cl.praxis.controlReclamosTransporte.model.repository;

import cl.praxis.controlReclamosTransporte.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}