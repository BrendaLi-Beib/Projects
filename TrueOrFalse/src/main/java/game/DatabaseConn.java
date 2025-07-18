package game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConn {
    private static final String URL = "jdbc:postgresql://localhost:5432/true_false_game";
    private static final String USER = "BrendaBecerra";
    private static final String PASSWORD = "libeib";
    private static final Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Question> getData(){
        List<Question> list = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM questions");
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                list.add(new Question(rs.getString("text"), rs.getBoolean("answer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}