package com.TomaszB.Project;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    private List<UserEntity> users = new ArrayList<>();
    private int nextId = 0;


    public UserService(){
        for (int i = 0; i < 50; i++){
            createUser(new UserEntity(i, "user " + i, "email " + i));
        }
    }

    public Object getUsers(int pageNumber, int pageSize)
    {
        List<UserEntity> result = new ArrayList<>();

        int start = (pageNumber - 1) * pageSize;
        int stop = start + pageSize;
        int index = 0;

        for (UserEntity entity : this.users){
            if(start <= index && index < stop){
                result.add(entity);
            }
            index++;
        }
        return result;
    }

    public Object getUser(int userId)
    {
        for (UserEntity entity : this.users){
            if(entity.getId() == userId)
                return entity;
        }
        return null;
    }

    public UserEntity createUser(UserEntity user) {
        user.setId(nextId);
        nextId++;

        users.add(user);

        return user;
    }

    public UserEntity updateUser(int userId, UserEntity newUser) {

        UserEntity user = null;

        for (UserEntity entity : this.users){
            if(entity.getId() == userId)
                user = entity;
        }

        if(user == null)
            return null;

        user = newUser;
        user.setId(userId);

        return user;
    }

    public Object removeUser(int userId) {
        UserEntity user = null;

        for (UserEntity entity : this.users){
            if(entity.getId() == userId)
                user = entity;
        }

        this.users.remove(user);

        return new Object(  );
    }
}
