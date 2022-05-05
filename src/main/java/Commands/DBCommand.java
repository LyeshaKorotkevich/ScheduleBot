package Commands;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DBCommand {
    private static final String DB_URL = "jdbc:postgresql://194.195.241.62:5432/l_korotkevich_db";
    private static final String USER = "l_korotkevich";
    private static final String PASS = "i-opqdlr";


    public static String getDay(String day) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            connection.setAutoCommit(false);
            PreparedStatement ps =
                    connection.prepareStatement("SELECT * FROM schedule WHERE day_of_week = ? ORDER BY id");
            ps.setString(1, day);
            ResultSet rs=ps.executeQuery();
            StringBuilder text = new StringBuilder();
            while (rs.next()){
                text.append(rs.getString(3)).append(" ");
                text.append(rs.getString(4)).append(" ");
                text.append(rs.getString(5)).append("\n");
            }
            return text.toString();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return "";
        }
    }

    public static String getWeek() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            connection.setAutoCommit(false);
            PreparedStatement ps =
                    connection.prepareStatement("SELECT * FROM schedule ORDER BY id");
            ResultSet rs=ps.executeQuery();
            HashMap<String, String> days= new LinkedHashMap<>();
            while (rs.next()){
                if (days.containsKey(WEEK_DAY.valueOf(rs.getString(2)).getDescription())) {
                    String text = rs.getString(3) + " " +
                            rs.getString(4) + " " +
                            rs.getString(5) + "\n";
                    days.put(WEEK_DAY.valueOf(rs.getString(2)).getDescription(), days.get(WEEK_DAY.valueOf(rs.getString(2)).getDescription()) + text);
                }else{
                    String text = rs.getString(3) + " " +
                            rs.getString(4) + " " +
                            rs.getString(5) + "\n";
                    days.put(WEEK_DAY.valueOf(rs.getString(2)).getDescription(), text);
                }
            }
            StringBuilder text = new StringBuilder();
            for (Map.Entry<String, String> stringStringEntry : days.entrySet()) {
                text.append(stringStringEntry.getKey()).append("\n");
                text.append(stringStringEntry.getValue()).append("\n");
            }
            return text.toString();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return "";
        }
    }
}
