package ru.soviet.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.soviet.spring.dao.UserDaoImp;
import ru.soviet.spring.models.User;
import ru.soviet.spring.service.UserService;

//Убрал @Transactional
//Связал с сервисом
@Controller
@RequestMapping("/")
public class UsersController {

    @Autowired
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@ModelAttribute("person") User user, Model model) {
        model.addAttribute("person", userService.show(user));
        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") User user) {
        userService.save(user);
        return "redirect:/";
    }//done

    @GetMapping("/{id}/edit")
    public String edit(@ModelAttribute("person") User user, Model model) {
        model.addAttribute("person", userService.show(user));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user) {
        userService.update(user);
        return "redirect:/";
    } //done

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("person") User user) {
        userService.delete(user);
        return "redirect:/";
    }
}
