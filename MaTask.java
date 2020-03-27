import java.sql.*;
import java.util.*;


public class MaTask extends TimerTask {
 public void run() {
        String url = "jdbc:mysql://localhost/projet_java";
        String login = "root";
        String passwd = "";
        Connection cn = null;
        Statement st = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            String sql = "INSERT INTO text (texte) VALUES ('Ici')";
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        finally{
            try{
                cn.close();
                st.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
  }