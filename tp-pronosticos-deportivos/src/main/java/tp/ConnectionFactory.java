
package tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Martin Lemberger
 */

public class ConnectionFactory {
    
    public Connection conexion() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:sqlite:pronosticos.db");
    }
}
