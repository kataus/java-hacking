package ru.itvitality.education.jh.sqlinj.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.itvitality.education.jh.sqlinj.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Service
@AllArgsConstructor
public class UserDaoJdbcImpl implements UserDao{
    private final JdbcOperations jdbc;

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getById( Integer id ) {
        return null;
    }

    @Override
    public List<User> getByName( String name ) {
        String query = "select * from users " +
                "where name = '" + name + "'";

        return jdbc.query( query,  new UserDaoJdbcImpl.UserMapper());
    }

    @Override
    public User update( User user ) {
        return user;
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow( ResultSet resultSet, int i) throws SQLException {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            return new User(id, name, password);
        }
    }
}
