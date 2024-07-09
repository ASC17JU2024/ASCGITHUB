package com.ecz.model;

// Simulated UserManager class
    class UserManager {
        private Database database;

        UserManager(Database database) {
            this.database = database;
        }

        void addUser(User user) {
            database.addUser(user);
        }

        void removeUser(String username) {
            database.removeUser(username);
        }

        boolean userExists(String username) {
            return database.userExists(username);
        }
    }