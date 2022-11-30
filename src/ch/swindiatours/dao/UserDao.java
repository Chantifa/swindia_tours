package ch.swindiatours.dao;

import ch.swindiatours.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Connection con;

        private String query;
        private PreparedStatement pst;
        private ResultSet rs;
        public UserDao(Connection con) {
            this.con = con;
        }


        public boolean userRegister(User user){
            boolean result = false;
            try {
                query = "insert into swindiatours.public.users (id, name, email, password) values(?,?,?,?)";
                pst = this.con.prepareStatement(query);
                pst.setInt(1, user.getId());
                pst.setString(2, user.getName());
                pst.setString(3, user.getEmail());
                pst.setString(4, user.getPassword());
                pst.executeUpdate();
                result = true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return result;
        }
        public User userLogin(String email, String password){
            User user = null;
            try{
                query = "select * from swindiatours.public.users where email=? and password=?";
                pst = this.con.prepareStatement(query);
                pst.setString(1,email);
                pst.setString(2,password);
                rs = pst.executeQuery();
                if(rs.next()){
                    user= new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setName(rs.getString("email"));
                }
            }
            catch (SQLException e) {
                System.out.print(e.getMessage());
            }
            return user;
        }

}
