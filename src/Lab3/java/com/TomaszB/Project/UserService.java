package com.TomaszB.Project;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final String filePath = "users.obf";
    private List<UserEntity> users = new ArrayList<>();
    private int nextId = 0;




    @PostConstruct
    private void onCreate() {
        // wczytywanie uzytkowników
        boolean endOfFile = false;
        UserEntity temp;
        try {

            FileInputStream employeesFile = new FileInputStream(filePath);
            ObjectInputStream employeesStream = new ObjectInputStream(employeesFile);
            temp = (UserEntity) employeesStream.readObject();

            while (endOfFile != true) {
                try {
                    users.add(temp);
                    temp = (UserEntity) employeesStream.readObject();
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
            employeesStream.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("File could not be read");
        } catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        } finally {
            System.out.println("File loaded!");
        }

        if(users.size() == 0){
            initializeUsersList();
        }
    }
    @PreDestroy
    private void onDestroy() {
        // zapisywanie uzytkowników
        try {
            FileOutputStream EmployeesFile = new FileOutputStream(filePath);
            ObjectOutputStream EmployeesStream = new ObjectOutputStream(EmployeesFile);

            for (UserEntity entity : users) {
                EmployeesStream.writeObject(entity);
            }
            EmployeesStream.close();
        } catch (IOException e) {
            // System.out.println("Error occurred while saving");
            e.printStackTrace();
        }finally {
            System.out.println("File saved!");
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

        updateUser(user, newUser);

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

    private void updateUser(UserEntity entity, UserEntity update){
        entity.setName(update.getEmail());
        entity.setEmail(update.getEmail());
    }
    private void initializeUsersList(){
        for (int i = 0; i < 50; i++){
            createUser(new UserEntity(i, "user " + i, "email " + i));
        }
    }
}
