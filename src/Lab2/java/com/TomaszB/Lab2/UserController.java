package com.TomaszB.Lab2;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller()
@RequestMapping("/users")
public class UserController {

    Map<Integer, UserEntity> users = new HashMap<>();

    public UserController(){
    }

    @ResponseBody
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object index(){
        return users;
    }

    @ResponseBody
    @RequestMapping(
            value = "/{id}/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getUser(@PathVariable int id){
        var user = users.get(id);

        return user;
    }

    @ResponseBody
    @RequestMapping(
            value = "/{id}/remove",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object removeUser(@PathVariable int id){
        var user = users.get(id);

        users.remove(id);

        return user;
    }

    @ResponseBody
    @RequestMapping(
            value = "/add",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addUser(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age)
    {
        UserEntity user = new UserEntity(name, age);

        AddUser(user);
        return user;
    }

    private void AddUser(UserEntity user){
        users.put(users.size(), user);
    }
}
