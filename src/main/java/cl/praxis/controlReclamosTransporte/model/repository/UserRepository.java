package cl.praxis.controlReclamosTransporte.model.repository;

import cl.praxis.controlReclamosTransporte.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}