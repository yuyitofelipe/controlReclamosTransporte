package cl.praxis.controlReclamosTransporte.model.service;

import cl.praxis.controlReclamosTransporte.model.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    boolean create(User user);
    boolean update(User user);
    boolean delete(Integer id);
}