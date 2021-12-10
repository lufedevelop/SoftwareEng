//Class to store all information about a manager
package sample;

final class DBManager {
    private final String user;
    private final String pass;
    private final String mail;
    private final String name;

    public DBManager(String user, String pass, String mail, String name){
        this.user = user;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
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

}
