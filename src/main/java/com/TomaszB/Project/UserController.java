package com.TomaszB.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    private UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("")
    public String index(){
        return "Index!";
    }




    @ResponseBody
    @RequestMapping("/getUsers")
    public Object getUsers(
            @RequestParam(name = "page-number", defaultValue = "1") int pageNumber,
            @RequestParam(name = "page-size", defaultValue = "1") int pageSize)
    {
        return this.userService.getUsers(pageNumber, pageSize);
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public Object getUser(
            @RequestParam(name = "id", defaultValue = "1") int userId)
    {
        return this.userService.getUser(userId);
    }

    @ResponseBody
    @RequestMapping("/{id}/remove")
    public Object removeUser(@RequestParam int id)
    {
        return this.userService.removeUser(id);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public UserEntity createUser(@RequestBody UserEntity user) {
        return this.userService.createUser(user);
    }


    @RequestMapping(
            value = "/{id}/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public UserEntity updateUser(@RequestParam int id, @RequestBody UserEntity user) {
        return this.userService.updateUser(id, user);
    }
}
