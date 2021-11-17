package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public boolean passwordCheck(String password) {
        return Pattern.matches("\\A(?=.{8,}\\z)(?=[^A-Za-z]*[A-Za-z])(?=\\D*\\d).*", password);
//        return true;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDB.findAll();
    }

    @Override
    public void deleteUser(String idUser) {
        UserModel user = userDB.findById(idUser);
        userDB.delete(user);
    }

    @Override
    public Integer ubahPassword(String username, String passLama, String passBaru, String passKonfirm) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserModel user = userDB.findByUsername(username);

        // Menyamakan password konfirmasi
        if (!passBaru.equals(passKonfirm)) {
            return 0;
        }

        // Menyamakan password baru dengan syarat
        if (!passwordCheck(passBaru)) {
            return -2;
        }

        // Samain pass lama input dengan pass lama database
        if (passwordEncoder.matches(passLama , user.getPassword())) {
            String hashpassword = encrypt(passBaru);
            user.setPassword(hashpassword);
            userDB.save(user);
            return 1;
        }

        return -1;
    }
}
