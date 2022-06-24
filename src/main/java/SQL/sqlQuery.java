package SQL;





import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class sqlQuery {


//SQL request and создание списка объектов пользовательского формата POJO
    public static List<User> sqlQuery(String query) throws SQLException {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = ps.getMetaData();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            userList.add(new User(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("second_name"), rs.getInt("age"), rs.getBoolean("sex"),
                    rs.getDouble("money")));
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                System.out.print(rs.getString());
//            }

        }
        rs.close();
        st.close();
        return userList;
    }
    //Получаем список таблиц
    static void getTables () throws SQLException {
        Connection conn = getConnection();
        DatabaseMetaData dbmd = conn.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = dbmd.getTables(null, null, "%", types);
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
        rs.close();
    }

    //Create connection with database using JDCB
    public static Connection getConnection() throws SQLException {
        String sqlURL = "jdbc:postgresql://77.50.236.203:4832/pflb_trainingcenter";

        Connection conn = DriverManager.getConnection(sqlURL,
                "pflb-at-read", "PflbQaTraining2354");

        return conn;
    }
// Получаем имя колонок
    static void getColumnName(String tableName) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from "+ tableName);
        ResultSetMetaData dbmd = pstmt.getMetaData();
        for (int i = 1; i <=  dbmd.getColumnCount(); i++)
        {
            System.out.print(dbmd.getColumnName(i) +"\t");
        }
        pstmt.close();
    }
}


