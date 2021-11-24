package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(
            @ModelAttribute UserModel user,
            Model model,
            Authentication authentication)
    {
        try {
            if (userService.passwordCheck(user.getPassword())) {
                userService.addUser(user);
                model.addAttribute("user", user);
                return "redirect:/";
            }
            UserModel user2 = new UserModel();
            model.addAttribute("user", user2);
            model.addAttribute("error", "Password harus mengandung minimal 8 digit, angka, huruf besar kecil, dan simbol");
            model.addAttribute("listRole", roleService.getListRole());
            return "form-add-user";
        } catch (DataIntegrityViolationException e) {
            UserModel user2 = new UserModel();
            model.addAttribute("user", user2);
            model.addAttribute("error", "Username sudah digunakan");
            model.addAttribute("listRole", roleService.getListRole());
            return "form-add-user";
        }
    }

    @GetMapping("/viewall")
    private String viewAllUser(Model model) {
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/viewall/delete/{idUser}")
    private String deleteUser(
            Model model,
            @PathVariable String idUser
    ){
        userService.deleteUser(idUser);
        model.addAttribute("pesan", "User dengan ID " + idUser + " telah dihapus");
        return "message";
    }

    @GetMapping("/update-password")
    private String ubahPasswordForm(
            Model model,
            Authentication authentication
    ) {
        return "form-update-user-password";
    }

    @PostMapping("/update-password")
    private String ubahPassword(
            Model model,
            @RequestParam("passLama") String passLama,
            @RequestParam("passBaru") String passBaru,
            @RequestParam("passKonfirm") String passKonfirm,
            Principal principal
    ) {
        Integer result = userService.ubahPassword(principal.getName(), passLama, passBaru, passKonfirm);

        if (result == 0) {
            model.addAttribute("error", "Password Baru dengan Konfirmasi berbeda");
        } else if (result == 1) {
            model.addAttribute("pesan", "Berhasil mengubah password");
            return "message";
        } else if (result == -1) {
            model.addAttribute("error", "Password lama salah");
        } else if (result == -2) {
            model.addAttribute("error", "Password harus mengandung minimal 8 digit, angka, huruf besar kecil, dan simbol");
        }

        return "form-update-user-password";
    }
}
