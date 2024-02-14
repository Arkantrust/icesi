package me.arkantrust.repository;

import java.util.ArrayList;

import me.arkantrust.model.User;

import me.arkantrust.filesapi.FileHandler;

public class UserRepository {

    private final FileHandler<ArrayList<User>> handler;

    public UserRepository(FileHandler<ArrayList<User>> handler) {

        this.handler = handler;

    }

    public ArrayList<User> getAll() {

        return handler.load(User.class);

    }

    public User getById(int id) {

        ArrayList<User> users = handler.load(User.class);

        int left = 0;
        int right = users.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (users.get(mid).id() == id) {

                return users.get(mid);

            }

            if (users.get(mid).id() < id) {

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

        return null;

    }

    public void add(User user) {

        ArrayList<User> users = handler.load(user.getClass());

        users.add(user);

        handler.save(users);

    }

    public void remove(int id) {

        ArrayList<User> users = handler.load(User.class);

        int left = 0;

        int right = users.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (users.get(mid).id() == id) {

                users.remove(mid);

                break;

            }

            if (users.get(mid).id() < id) {

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

        // TODO: Don't know yet if this is needed. Will know when testing is done.
        // Consequences of not doing TDD :(
        users.sort((a, b) -> a.id() - b.id());

        handler.save(users);

    }

    public void update(int id, User user) {

        ArrayList<User> users = handler.load(User.class);

        int left = 0;

        int right = users.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (users.get(mid).id() == id) {

                users.set(mid, user);

                break;

            }

            if (users.get(mid).id() < id) {

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

    }

}
