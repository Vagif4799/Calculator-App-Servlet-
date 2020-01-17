package calculatorApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseOperations {

        public static void insert_op(int op1, int op2, String op, int result, int user) {
            try {
                Connection conn = DataBaseConnection.get();
                String SQLI = "insert into operations (op1, op2, op, r, user_id) VALUES (?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(SQLI);
                stmt.setInt(1, op1);
                stmt.setInt(2, op2);
                stmt.setString(3, op);
                stmt.setInt(4, result);
                stmt.setInt(5, user);
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException("DbOpsEX!!!", e);
            }
        }

}
