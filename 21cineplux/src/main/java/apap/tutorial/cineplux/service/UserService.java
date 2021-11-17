package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    boolean passwordCheck(String password);
    List<UserModel> getListUser();
    void deleteUser(String idUser);
    Integer ubahPassword(String user, String passLama, String passBaru, String passKonfirm);
}
