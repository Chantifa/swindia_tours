package ch.swindiatours.dao;

import ch.swindiatours.model.User;

import java.sql.*;

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
                query = "insert into swindiatours.public.users ( name, email, password) values(?,?,?)";
                pst = this.con.prepareStatement(query);
                pst.setString(1, user.getName());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPassword());
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
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setId(rs.getInt("id"));
                    System.out.println("here ist der user mit id"+user.getId());
                }
            }
            catch (SQLException e) {
                System.out.print(e.getMessage());
            }
            return user;
        }
}
