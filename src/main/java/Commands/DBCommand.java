package Commands;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DBCommand {
    private static final String DB_URL = "jdbc:postgresql://194.195.241.62:5432/l_korotkevich_db";
    private static final String USER = "l_korotkevich";
    private static final String PASS = "i-opqdlr";
    private static final String[] emojis = {"1️⃣", "2️⃣", "3️⃣", "4️⃣"};

    public static Connection getConn(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
        }catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return conn;
    }

    public static String getDay(String day) {
        try {
            Connection connection = getConn();
            if (connection == null){
                throw new NullPointerException();
            }
            PreparedStatement ps =
                    connection.prepareStatement("SELECT * FROM schedule WHERE day_of_week = ? ORDER BY id");
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();
            StringBuilder text = new StringBuilder();
            while (rs.next()) {
                text.append(emojis[rs.getInt("nom") - 1]).append(rs.getString("subject")).append(" ");
                text.append(rs.getString("teacher")).append(" ");
                text.append(rs.getString("cabinet")).append("\n");
            }
            connection.close();
            return text.toString();
        }catch (SQLException | ArrayIndexOutOfBoundsException e ) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getWeek() {
        try{
            Connection connection = getConn();
            if (connection == null){
                throw new NullPointerException();
            }
            PreparedStatement ps =
                    connection.prepareStatement("SELECT * FROM schedule ORDER BY id");
            ResultSet rs=ps.executeQuery();
            HashMap<String, String> days= new LinkedHashMap<>();
            while (rs.next()){
                if (days.containsKey(WEEK_DAY.valueOf(rs.getString("day_of_week")).getDescription())) {
                    String text = emojis[rs.getInt("nom")-1] + rs.getString("subject") + " " +
                            rs.getString("teacher") + " " +
                            rs.getString("cabinet") + "\n";
                    days.put(WEEK_DAY.valueOf(rs.getString("day_of_week")).getDescription(), days.get(WEEK_DAY.valueOf(rs.getString("day_of_week")).getDescription()) + text);
                }else{
                    String text = emojis[rs.getInt(6)-1] + rs.getString(3) + " " +
                            rs.getString(4) + " " +
                            rs.getString(5) + "\n";
                    days.put(WEEK_DAY.valueOf(rs.getString("day_of_week")).getDescription(), text);
                }
            }
            StringBuilder text = new StringBuilder();
            for (Map.Entry<String, String> stringStringEntry : days.entrySet()) {
                text.append(stringStringEntry.getKey()).append("\n");
                text.append(stringStringEntry.getValue()).append("\n");
            }
            connection.close();
            return text.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
}
