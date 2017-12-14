package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "All Users");

        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Add User");

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,
                                     Errors errors, @RequestParam String verify) {

        if (!user.getPassword().equals(verify)) {
            model.addAttribute("pw_error", "Passwords do not match");
            return "user/add";

        } else if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute(user);
            return "user/add";
        }

        UserData.add(user);
        return "redirect:";

    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String displaySingleUser(@PathVariable int userId, Model model) {


        // TODO: Pass in username as title on each page

        UserData.getById(userId);
        model.addAttribute("user", UserData.getById(userId));
        model.addAttribute("title", "Single User");

        return "/user/user";

    }

}
