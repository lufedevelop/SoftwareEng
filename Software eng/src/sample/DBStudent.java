//Class to store all information about a student
package sample;

final class DBStudent {
    private final String user;
    private final String pass;
    private final String mail;
    private final String name;
    private final int year;
    private final int resID;

    public DBStudent(String user, String pass, String mail, String name, int year, int resID){
        this.user = user;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
        this.year = year;
        this.resID = resID;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getResID() {
        return resID;
    }
}
