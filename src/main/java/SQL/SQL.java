package SQL;





import Prop.PropertiesConf;
import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQL {


//SQL request and создание списка объектов пользовательского формата POJO
    public ResultSet query(String query) throws SQLException {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
//        rs.close();
//        st.close();
        return rs;
    }

    public List<User> getUserListFromResultSet(ResultSet rs){
        List<User> userList = new ArrayList<User>();
        try {
            while (rs.next()) {
                userList.add(new User(rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("second_name"), rs.getInt("age"), rs.getBoolean("sex"),
                        rs.getDouble("money")));
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }
        return userList;
        }



    //Получаем список таблиц
     void getTables () throws SQLException {
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
        String sqlURL = PropertiesConf.getValue("sqlURL");

        Connection conn = DriverManager.getConnection(sqlURL,
                PropertiesConf.getValue("sqlUser"), PropertiesConf.getValue("sqlPassw"));

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


