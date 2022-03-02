package ru.soviet.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.soviet.spring.dao.UserDaoImp;
import ru.soviet.spring.models.User;

@Controller
@Transactional
@RequestMapping("/")
    public class UsersController {

        @Autowired
        private final UserDaoImp userDaoImp;

        public UsersController(UserDaoImp personDAO) {
            this.userDaoImp = personDAO;
        }

        @GetMapping()
        public String index(Model model) {
            model.addAttribute("users", userDaoImp.index());
            return "users/index";
        }

        @GetMapping("/{id}")
        public String show(@PathVariable("id") int id, Model model) {
            model.addAttribute("person", userDaoImp.show(id));
            return "users/show";
        }

        @GetMapping("/new")
        public String newPerson(Model model){
            model.addAttribute("person", new User());
            return "users/new";
        }

        @PostMapping()
        public String create(@ModelAttribute("person") User user) {
            userDaoImp.save(user);
            return "redirect:/";
        }

        @GetMapping("/{id}/edit")
        public String edit(Model model, @PathVariable("id") int id) {
            model.addAttribute("person", userDaoImp.show(id));
            return "users/edit";
        }

        @PatchMapping("/{id}")
        public String update(@ModelAttribute("person") User user, @PathVariable("id") int id){
           userDaoImp.update(id,user);
           return "redirect:/";
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable("id") int id) {
            userDaoImp.delete(id);
            return "redirect:/";
        }
}
