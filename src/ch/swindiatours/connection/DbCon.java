package ch.swindiatours.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DbCon {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            javax.sql.DataSource ds = (javax.sql.DataSource)
                    ctx.lookup("jdbc/swindiatours");
            connection = ds.getConnection();

            return connection; // returns the connection.
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.close();
                    return connection;
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return connection;
        }
    }
}
