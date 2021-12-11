package sample;


import java.sql.*;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Driver {
    //check if the user is a student in the db
    public static DBStudent isStudent(String user_GUI, String password_GUI) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/myresidence_db";
        String user = "root";
        String pass = "root";
        System.out.println("username to check is "+ user_GUI+ "  password to check is "+password_GUI);
        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Create a statement
            myStmt = myConn.createStatement();
            // Get a result from the db
            myRs = myStmt.executeQuery("select * from student");
            while (myRs.next()){
                String student_user_DB = myRs.getString("student_username");
                String student_password_DB = myRs.getString("student_password");
                String student_email_DB = myRs.getString("student_email");
                String student_name_DB = myRs.getString("student_name");
                int year_num_DB = myRs.getInt("year_num");
                int residence_ID_DB = myRs.getInt("residence_ID");
                System.out.println(student_user_DB);
                System.out.println(student_password_DB);
                if (student_user_DB.equals(user_GUI) && student_password_DB.equals(password_GUI)){
                    System.out.println("username "+ user_GUI+ "  is Student");
                    return new DBStudent(student_user_DB, student_password_DB, student_email_DB, student_name_DB,
                            year_num_DB, residence_ID_DB);
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
    //check if the user is a manager in the db
    public static DBManager isManager(String user_GUI, String password_GUI) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/myresidence_db";
        String user = "root";
        String pass = "root";
        System.out.println("username to check is "+ user_GUI+ "  password to check is "+password_GUI);
        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Create a statement
            myStmt = myConn.createStatement();
            // Get a result from the db
            myRs = myStmt.executeQuery("select * from manager");
            while (myRs.next()){
                String manager_user_DB = myRs.getString("manager_username");
                String manager_password_DB = myRs.getString("manager_password");
                String manager_email_DB = myRs.getString("manager_email");
                String manager_name_DB = myRs.getString("manager_name");
                System.out.println(manager_user_DB);
                System.out.println(manager_password_DB);
                if (manager_user_DB.equals(user_GUI) && manager_password_DB.equals(password_GUI)){
                    System.out.println("username "+ user_GUI+ "  is Manager");
                    return new DBManager(manager_user_DB, manager_password_DB, manager_email_DB, manager_name_DB);
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
    //check if in the db a room with the keyword exists
    public static ArrayList<DBResidence> isResidence(String keyword) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/myresidence_db";
        String user = "root";
        String pass = "root";
        System.out.println("keyword to search for is "+ keyword);
        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Create a statement
            myStmt = myConn.createStatement();
            // Get a result from the db
            myRs = myStmt.executeQuery("select * from residence");
            ArrayList <DBResidence> rooms = new ArrayList<DBResidence>();
            while (myRs.next()){
                Integer residence_ID_DB = myRs.getInt("residence_ID");
                String living_style_DB = myRs.getString("living_style");
                String room_type_DB = myRs.getString("room_type");
                Integer residence_price_DB = myRs.getInt("residence_price");
                String residence_address_DB = myRs.getString("residence_address");
                boolean has_mealplan_DB = myRs.getBoolean("has_mealplan"); //not a keyword for the search
                String student_usernames_DB = myRs.getString("student_usernames"); //not a keyword for the search
                if (NumberUtils.isParsable(keyword)){
                    Integer intKeyword = Integer.parseInt(keyword);
                    if (residence_price_DB.equals(intKeyword) || residence_ID_DB.equals(intKeyword)){
                        System.out.println("room for keyword "+keyword+" found");
                        rooms.add(new DBResidence(residence_ID_DB, living_style_DB, room_type_DB, residence_price_DB,
                                residence_address_DB, has_mealplan_DB, student_usernames_DB));
                    }
                }
                else if (residence_address_DB.equals(keyword) || living_style_DB.equals(keyword) ||
                        room_type_DB.equals(keyword)){
                    System.out.println("room for keyword "+keyword+" found");
                    rooms.add(new DBResidence(residence_ID_DB, living_style_DB, room_type_DB, residence_price_DB,
                            residence_address_DB, has_mealplan_DB, student_usernames_DB));
                }
                else {
                    System.out.println("no room for keyword " +keyword+" found");
                }
            }
            return rooms;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
    //add a student to a room in the db
    public static boolean addStudentToRoom(String username, int roomID){
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/myresidence_db";
        String user = "root";
        String pass = "root";
        System.out.println("user to add is "+ username + " room ID is " + roomID);
        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Create a statement
            myStmt = myConn.createStatement();
            // check how many usernames are in the room
            myRs = myStmt.executeQuery("select * from residence");
            int maxUser = 0;
            String currentUsers = null;
            String strUsers = null;
            while (myRs.next()) {
                Integer residence_ID_DB = myRs.getInt("residence_ID");
                String living_style_DB = myRs.getString("living_style");
                String room_type_DB = myRs.getString("room_type");
                String student_usernames_DB = myRs.getString("student_usernames");
                if (residence_ID_DB.equals(roomID)) {
                    if (living_style_DB.equals("Residence Hall") && room_type_DB.equals("Basic Single") ||
                    room_type_DB.equals("Single")){
                        maxUser = 1;
                        currentUsers = student_usernames_DB;
                    }
                    if (living_style_DB.equals("Residence Hall") && room_type_DB.equals("Double")){
                        maxUser = 2;
                        currentUsers = student_usernames_DB;
                    }
                    if (living_style_DB.equals("Townhouse") || living_style_DB.equals("Apartment")){
                        maxUser = 4;
                        currentUsers = student_usernames_DB;
                    }
                }
            }
            //room doesn't exist
            if (maxUser==0){
                System.out.println("room "+ roomID+ "  doesn't exist");
                return false;
            }
            if (currentUsers == null){
                strUsers = username;
            }
            else {
                String[] splitStr = currentUsers.split("\\s+");
                //room is already full
                if (splitStr.length >= maxUser) {
                    System.out.println("room "+ roomID+ "  is full");
                    return false;
                }
                //add new username to the list of users
                else {
                    String[] newUsers = new String[splitStr.length];
                    for (int i = 0; i <= splitStr.length; i++) {
                        newUsers[i] = splitStr[i];
                    }
                    strUsers = newUsers.toString();
                }
            }
            // update the db table residence
            PreparedStatement prep = myConn.prepareStatement("update residence set student_usernames=? where residence_ID=?");
            prep.setString(1, strUsers);
            prep.setInt(2, roomID);
            prep.executeUpdate();
            // update the db table student
            prep = myConn.prepareStatement("update student set residence_ID=? where student_username=?");
            prep.setInt(1, roomID);
            prep.setString(2, username);
            prep.executeUpdate();
            System.out.println("user "+ username+" is added to room "+roomID);
            return true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;
    }
    //add a new room to the db
    public static boolean addRoom(int residence_ID, String living_style, String room_type,
                                  int residence_price,String residence_address,
                                  boolean has_mealplan, String student_usernames){
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/myresidence_db";
        String user = "root";
        String pass = "root";
        System.out.println("room to add is "+ residence_ID);
        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Create a statement
            myStmt = myConn.createStatement();
            // check how many usernames are in the room
            myRs = myStmt.executeQuery("select * from residence");
            while (myRs.next()) {
                Integer residence_ID_DB = myRs.getInt("residence_ID");
                if (residence_ID_DB.equals(residence_ID)) {
                    //room already exists
                    System.out.println("room "+residence_ID+" already exists");
                    return false;
                }
            }
            PreparedStatement prep = myConn.prepareStatement(
                    "insert into residence (residence_ID, living_style, room_type, residence_price," +
                            "residence_address, has_mealplan, student_usernames) values (?, ?, ? ,? ,? ,? ,?)");
            prep.setInt(1, residence_ID);
            prep.setString(2, living_style);
            prep.setString(3, room_type);
            prep.setInt(4, residence_price);
            prep.setString(5, residence_address);
            prep.setBoolean(6, has_mealplan);
            prep.setString(7, student_usernames);
            prep.executeUpdate();
            System.out.println("room "+residence_ID+" is added to the database");
            return true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;
    }
    //delete a room from the db
    public static boolean deleteRoom(int roomID) {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/myresidence_db";
        String user = "root";
        String pass = "root";
        System.out.println("room to remove is " + roomID);
        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Create a statement
            myStmt = myConn.createStatement();
            // check how many usernames are in the room
            myRs = myStmt.executeQuery("select * from residence");
            while (myRs.next()) {
                Integer residence_ID_DB = myRs.getInt("residence_ID");
                if (residence_ID_DB.equals(roomID)) {
                    //room to delete found
                    PreparedStatement prep = myConn.prepareStatement("delete from residence where residence_ID=?");
                    prep.setInt(1, roomID);
                    prep.executeUpdate();
                    System.out.println("room "+roomID+" is deleted");
                    return true;
                }
            }
            System.out.println("room "+roomID+" doesn't exists");
            //room not found
            return false;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;
    }
}
