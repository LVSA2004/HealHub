package br.com.fiap.healhub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class UserService {

    @Autowired
    UserRepository repository;

    public void saveUser(User user) {
    }
}
