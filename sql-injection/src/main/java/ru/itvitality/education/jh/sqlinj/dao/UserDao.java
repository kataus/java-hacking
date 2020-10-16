package ru.itvitality.education.jh.sqlinj.dao;

import ru.itvitality.education.jh.sqlinj.dto.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getById(Integer id);

    List<User> getByName( String name );

    User update(User user);
}
