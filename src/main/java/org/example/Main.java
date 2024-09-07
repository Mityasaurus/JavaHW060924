package org.example;

import org.example.dao.UserDAO;
import org.example.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = new User(0, "Testov", "Oleg", User.Gender.MALE, LocalDateTime.now());
        User user2 = new User(0, "Diyova", "Anna", User.Gender.FEMALE, LocalDateTime.now());
        //
        //User saved = userDAO.save(user2);
        //System.out.println(saved);
        //
        User user1 = userDAO.findById(2);
        System.out.println(user1);
        //
        /*user1.setName("Updated Oleg");
        user1.setSurname("Update-ov");
        User updated = userDAO.update(user1);
        System.out.println(updated);
        System.out.println(userDAO.findById(updated.getId()));*/
        //
        //userDAO.delete(user1.getId());
        //
        List<User> users = userDAO.getAll();
        users.forEach(System.out::println);
    }
}