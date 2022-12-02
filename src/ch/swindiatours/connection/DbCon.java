package ch.swindiatours.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DbCon {
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            javax.sql.DataSource ds = (javax.sql.DataSource)
                    ctx.lookup("jdbc/swindiatours");
            connection = ds.getConnection();

        } catch (Exception e) {
            connection.close();
            //throws an error if at all its unable to create an connection
            System.out.println(e);
        }
        return connection; // returns the connection.
    }
}
