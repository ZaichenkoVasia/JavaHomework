package ua.mycompany.proxy.service;

import ua.mycompany.proxy.domain.User;

public interface UserService {
    User findById(Long id);
}
