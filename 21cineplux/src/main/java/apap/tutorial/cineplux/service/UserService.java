package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
}
