package ua.mycompany.proxy.service;

import ua.mycompany.proxy.domain.User;
import ua.mycompany.proxy.exception.EntityNotFoundRuntimeException;
import ua.mycompany.proxy.exception.EntityNullRuntimeException;

public class UserServiceImpl implements UserService {
    @Override
    public User findById(Long id) {
        if (id == null) {
            throw new EntityNullRuntimeException("Id can not be null");
        }
        if (id == 1) {
            return new User();
        }
        throw new EntityNotFoundRuntimeException("User not found");
    }
}
