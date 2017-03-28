package ua.com.kopunova.service.form;

import ua.com.kopunova.model.User;

import java.util.List;

public class MainForm {
    private List<User> users;

    public void setAllUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }
}





























