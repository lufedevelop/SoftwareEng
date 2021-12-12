//Class to store all information about a student
package sample;

final class DBStudent {
    private final String user;
    private final String pass;
    private final String mail;
    private final String name;
    private final int year;
    private final int resID;
    private final boolean application_pending;

    public DBStudent(String user, String pass, String mail, String name, int year, int resID, boolean application_pending){
        this.user = user;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
        this.year = year;
        this.resID = resID;
        this.application_pending = application_pending;
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

    public boolean isApplication_pending() {
        return application_pending;
    }
}
