
package cl.praxis.controlReclamosTransporte.model.service;

import cl.praxis.controlReclamosTransporte.model.entities.User;
import cl.praxis.controlReclamosTransporte.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean create(User user) {
        userRepository.save(user);
        logger.info("Usuario creado con ID: {}", user.getUserId());
        return true;
    }

    @Override
    @Transactional
    public boolean update(User user) {
        if (userRepository.existsById(user.getUserId())) {
            userRepository.save(user);
            logger.info("Usuario actualizado con el ID: {}", user.getUserId());
            return true;
        }
        logger.warn("Se intentó actualizar un usuario que no existe con ID: {}", user.getUserId());
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        boolean exist = userRepository.existsById(id);
        if (exist) {
            userRepository.deleteById(id);
            logger.info("Usuario eliminado con ID: {}", id);
        } else {
            logger.warn("Se intentó eliminar un usuario que no existe con ID: {}", id);
        }
        return exist;
    }
}
