package com.sandbox_gradle.test_01_02.package2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseImp implements Base {
    private final List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public User getByLastname(String name) {
        return users.stream().filter((User user) ->
                name.equals(user.getLastName())).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void delete(String lastName) {
        try {
            users.remove(users.stream().filter(user -> lastName.equals(user.getLastName()))
                    .findFirst().orElse(null));
            System.out.println("User deleted!");
        }catch (NullPointerException e){
            System.out.println("User not found!");
        }
    }
}
