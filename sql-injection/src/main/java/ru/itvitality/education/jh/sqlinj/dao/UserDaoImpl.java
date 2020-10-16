package ru.itvitality.education.jh.sqlinj.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.itvitality.education.jh.sqlinj.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDaoImpl  implements UserDao{
    private final JdbcOperations jdbc;

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getById( Integer id ) {
        String query = "select * from users " +
                "where id = " + id + "";
        return jdbc.query( query, new UserDaoImpl.UserMapper())
                .stream().findFirst().orElse( null );
    }

    @Override
    public List<User> getByName( String name ) {
        String query = "select * from users " +
                "where name = '" + name + "'";
        return jdbc.query( query, new UserDaoImpl.UserMapper());
    }

    @Override
    public User update( User user ) {
        String query = "update users " +
                "set name = '"+user.getName()+"' " +
                "    password = '" + user.getPassword() + "'" +
                " where id =    " + user.getId() ;
        jdbc.update( query );
        return getById( user.getId() );
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
