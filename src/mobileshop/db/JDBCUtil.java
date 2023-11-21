
package mobileshop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author phatlee
 */
public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        final String url = "jdbc:mysql://localhost:3306/mobile_shop";
        final String user = "root";
        final String password = "1492004";
        try {
            Class.forName("com.mysql.jdbc.Driver"); // load driver
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect the database!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Cannot find the jdbc driver!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot close the connection!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
