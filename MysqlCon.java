// Author: Lukas Federle 1175785
// This class connects to the database
package sample.prototype;
// import for database connection
import java.sql.*;

public class MysqlCon {
    //function to check if login credentials are in the database
    //not good style, that database password is shown in the code
    public String check_user(String user_GUI, String password_GUI){
        System.out.println("username to check is "+ user_GUI+ "  password to check is "+password_GUI);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myresidencedb","root","root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from manager");
            while (rs.next()){
                String manager_user_DB = rs.getString("manager_username");
                String manager_password_DB = rs.getString("manager_password");
                System.out.println(manager_user_DB);
                System.out.println(manager_password_DB);
                if (manager_user_DB.equals(user_GUI) && manager_password_DB.equals(password_GUI)){
                    return "isManager";
                }
            }
            rs = stmt.executeQuery("select * from student");
            while (rs.next()){
                String student_user_DB = rs.getString("student_username");
                String student_password_DB = rs.getString("student_password");
                System.out.println(student_user_DB);
                System.out.println(student_password_DB);
                if (student_user_DB.equals(user_GUI) && student_password_DB.equals(password_GUI)){
                    return "isStudent";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "false";
    }
}
