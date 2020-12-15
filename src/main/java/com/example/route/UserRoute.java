package com.example.route;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;

    @Autowired
    public UserRoute(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> getUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/user_id")
    @ResponseBody
    public User getUser(@PathVariable(value = "user_id") String userId) throws Exception{
        return this.userService.find(Integer.parseInt(userId));
    }

    @GetMapping("/initialize")
    public void initializeUsers() {
        this.userService.initializeUsers();
    }
}
