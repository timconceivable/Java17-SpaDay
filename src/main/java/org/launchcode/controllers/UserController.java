package org.launchcode.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayUserIndex() {
        model.addAttribute("users", UserData.getAll());
        return "user/add";
    }

    @GetMapping("add")
    public displayAddUserForm() {
        return "/user/add"
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (verify.equals(user.getPassword())) {
            UserData.add(user);
            return "redirect:/";
        }
        model.addAttribute();
        model.addAttribute();
        model.addAttribute();
        return "user/add";
    }

    @GetMapping("details")
    public String getIserDetails(Model model, @RequestParam(required = false), Integer userId) {
        model.addAttribute("user", UserData.getById(userId));
    }

}