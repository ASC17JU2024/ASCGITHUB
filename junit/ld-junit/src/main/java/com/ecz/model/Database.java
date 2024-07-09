package com.ecz.model;

import java.util.ArrayList;
import java.util.List;

// Simulated Database class
class Database {
        private List<User> users = new ArrayList<>();

        void addUser(User user) {
            users.add(user);
        }

        void removeUser(String username) {
            users.removeIf(user -> user.getUsername().equals(username));
        }

        boolean userExists(String username) {
            return users.stream().anyMatch(user -> user.getUsername().equals(username));
        }

        void clear() {
            users.clear();
        }
    }